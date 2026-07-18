#!/bin/bash
# core/pom.xml has a system-scoped dependency on the paid RealisticSeasons
# plugin at ${user.home}/Downloads/RealisticSeasons.jar, which cannot be
# redistributed or downloaded in CI. This generates a compile-only stub of the
# exact API surface core uses (class and method signatures verified against
# RealisticSeasons 11.6.7) at that path. At runtime the real plugin is used.
set -euo pipefail

API_JAR=$(ls "$HOME"/.m2/repository/org/spigotmc/spigot-api/26.1.2-R0.1-SNAPSHOT/spigot-api-*-shaded.jar | head -1)
TMP=$(mktemp -d)
trap 'rm -rf "$TMP"' EXIT
mkdir -p "$TMP/src/me/casperge/realisticseasons/api" \
         "$TMP/src/me/casperge/realisticseasons/temperature" \
         "$TMP/classes" "$HOME/Downloads"

cat > "$TMP/src/me/casperge/realisticseasons/RealisticSeasons.java" <<'JAVA'
package me.casperge.realisticseasons;
import me.casperge.realisticseasons.temperature.TemperatureManager;
public class RealisticSeasons {
    public static RealisticSeasons getInstance() { throw new UnsupportedOperationException("compile stub"); }
    public TemperatureManager getTemperatureManager() { throw new UnsupportedOperationException("compile stub"); }
}
JAVA

cat > "$TMP/src/me/casperge/realisticseasons/api/SeasonsAPI.java" <<'JAVA'
package me.casperge.realisticseasons.api;
import org.bukkit.entity.Player;
public class SeasonsAPI {
    public static SeasonsAPI getInstance() { throw new UnsupportedOperationException("compile stub"); }
    public int getTemperature(Player player) { throw new UnsupportedOperationException("compile stub"); }
}
JAVA

cat > "$TMP/src/me/casperge/realisticseasons/temperature/TemperatureManager.java" <<'JAVA'
package me.casperge.realisticseasons.temperature;
import org.bukkit.entity.Player;
public class TemperatureManager {
    public TempData getTempData() { throw new UnsupportedOperationException("compile stub"); }
    public boolean hasFahrenheitEnabled(Player player) { throw new UnsupportedOperationException("compile stub"); }
    public boolean hasTemperature(Player player) { throw new UnsupportedOperationException("compile stub"); }
}
JAVA

cat > "$TMP/src/me/casperge/realisticseasons/temperature/TempData.java" <<'JAVA'
package me.casperge.realisticseasons.temperature;
public class TempData {
    public boolean isEnabled() { throw new UnsupportedOperationException("compile stub"); }
}
JAVA

find "$TMP/src" -name '*.java' -print0 | xargs -0 javac -cp "$API_JAR" -d "$TMP/classes"
jar cf "$HOME/Downloads/RealisticSeasons.jar" -C "$TMP/classes" .
echo "stub written to $HOME/Downloads/RealisticSeasons.jar"
