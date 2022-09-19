/*
    Copyright (C) 2022  Val_Mobile

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.val_mobile.utils;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import net.minecraft.SharedConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Guardian;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public enum CustomEntities {

    ENDERMAN_ALLY("enderman_ally", org.bukkit.entity.EntityType.ENDERMAN.getTypeId(), EntityType.ENDERMAN, Enderman.class, EndermanAlly.class),
    FIRE_DRAGON("fire_dragon", org.bukkit.entity.EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EnderDragon.class, FireDragon.class),
    ICE_DRAGON("ice_dragon", org.bukkit.entity.EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EnderDragon.class, IceDragon.class),
    LIGHTNING_DRAGON("lightning_dragon", org.bukkit.entity.EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EnderDragon.class, LightningDragon.class),
    SEA_SERPENT("sea_serpent", org.bukkit.entity.EntityType.ELDER_GUARDIAN.getTypeId(), EntityType.ELDER_GUARDIAN, ElderGuardian.class, SeaSerpent.class),
    SIREN("siren", org.bukkit.entity.EntityType.GUARDIAN.getTypeId(), EntityType.GUARDIAN, Guardian.class, Siren.class);

    public static List<Entity> customEntities = new ArrayList<>();

    private String name;
    private int id;
    private EntityType<?> entityType;
    private ResourceLocation minecraftKey;
    private Class<? extends Mob> nmsClass;
    private Class<? extends Entity> customClass;

    CustomEntities(String name, int id, EntityType entityType, Class<? extends Mob> nmsClass,
                           Class<? extends Entity> customClass) {
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.minecraftKey = new ResourceLocation(name);
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }

    public static void registerEntities() {
        Map<String, Type<?>> types = (Map<String, Type<?>>) DataFixers.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getCurrentVersion().getWorldVersion())).findChoiceType(References.ENTITY).types();
        unfreezeRegistry();
        registerEntity("fire_dragon", FireDragon::new, types);
        registerEntity("ice_dragon", IceDragon::new, types);
        registerEntity("lightning_dragon", LightningDragon::new, types);
        registerEntity("enderman_ally", EndermanAlly::new, types);
        registerEntity("sea_serpent", SeaSerpent::new, types);
        registerEntity("siren", Siren::new, types);
        Registry.ENTITY_TYPE.freeze();
    }

    private static void registerEntity(String type, EntityType.EntityFactory customMob, Map<String, Type<?>> types) {
        if (!Registry.ENTITY_TYPE.getOptional(new ResourceLocation(type)).isPresent()) {
            String customName = "minecraft:realisticsurvival_" + type;
            types.put(customName, types.get("minecraft:" + type));
            EntityType.Builder<net.minecraft.world.entity.Entity> a = EntityType.Builder.of(customMob, MobCategory.MONSTER);
            Registry.register(Registry.ENTITY_TYPE, customName, a.build(customName));
        }
    }

    private static void unfreezeRegistry() {
        Class<MappedRegistry> registryClass = MappedRegistry.class;
        try {
            Field intrusiveHolderCache = registryClass.getDeclaredField(ObfuscatedFields.INTRUSIVE_HOLDER_CACHE);
            intrusiveHolderCache.setAccessible(true);
            intrusiveHolderCache.set(Registry.ENTITY_TYPE, new IdentityHashMap<EntityType<?>, Holder.Reference<EntityType<?>>>());
            Field frozen = registryClass.getDeclaredField(ObfuscatedFields.FROZEN);
            frozen.setAccessible(true);
            frozen.set(Registry.ENTITY_TYPE, false);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void unregisterEntities() {}

    public static Object getPrivateField(Class<?> clazz, Object handle, String fieldName) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(handle);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public ResourceLocation getMinecraftKey() {
        return this.minecraftKey;
    }

    public Class<? extends Mob> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends Entity> getCustomClass() {
        return customClass;
    }

}
