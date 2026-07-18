#!/bin/bash
# Installs every org.spigotmc:spigot artifact the Maven reactor needs into the
# local repository, running BuildTools only for versions missing from the cache.
set -euo pipefail

REPO_ROOT="${1:?usage: run-buildtools.sh <repo root>}"
BT_DIR="$HOME/buildtools"
mkdir -p "$BT_DIR"
cd "$BT_DIR"

[ -f BuildTools.jar ] || curl -sLo BuildTools.jar \
  "https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar"

while read -r ver jdk; do
  [ -z "$ver" ] && continue
  case "$ver" in \#*) continue ;; esac

  if compgen -G "$HOME/.m2/repository/org/spigotmc/spigot/${ver}-R0.1-SNAPSHOT/spigot-${ver}-R0.1-SNAPSHOT.jar" > /dev/null; then
    echo "== spigot $ver already installed, skipping"
    continue
  fi

  jh_var="JAVA_HOME_${jdk}_X64"
  JH="${!jh_var:?missing $jh_var - is setup-java configured for JDK $jdk?}"

  # 26.1+ ships unobfuscated and has no Spigot mappings, so --remapped only
  # applies to the older versions whose modules compile against remapped-mojang.
  extra=""
  case "$ver" in 26.*) ;; *) extra="--remapped" ;; esac

  echo "== building spigot $ver with JDK $jdk"
  rm -rf "work-$ver"
  mkdir "work-$ver"
  ( cd "work-$ver" && JAVA_HOME="$JH" "$JH/bin/java" -jar ../BuildTools.jar --rev "$ver" $extra > build.log 2>&1 ) \
    || { echo "BuildTools failed for $ver, last log lines:"; tail -80 "work-$ver/build.log"; exit 1; }
  rm -rf "work-$ver"
done < "$REPO_ROOT/.github/ci/spigot-versions.txt"
