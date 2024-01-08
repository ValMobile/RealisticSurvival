/*
    Copyright (C) 2024  Val_Mobile

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.Map;

public enum CustomEntities_v1_19_R1 {

    ENDERMAN_ALLY("enderman_ally", EndermanAlly_v1_19_R1.class, EndermanAlly_v1_19_R1::new),
    FIRE_DRAGON("fire_dragon", FireDragon_v1_19_R1.class, FireDragon_v1_19_R1::new),
    ICE_DRAGON("ice_dragon", IceDragon_v1_19_R1.class, IceDragon_v1_19_R1::new),
    LIGHTNING_DRAGON("lightning_dragon", LightningDragon_v1_19_R1.class, LightningDragon_v1_19_R1::new),
    SEA_SERPENT("sea_serpent", SeaSerpent_v1_19_R1.class, SeaSerpent_v1_19_R1::new),
    SIREN("siren", Siren_v1_19_R1.class, Siren_v1_19_R1::new);

    private final String name;
    private final Class<? extends Entity> customClass;
    private final EntityType.EntityFactory customMob;
    private EntityType<Entity> customEntityType;


    CustomEntities_v1_19_R1(String name, Class<? extends Entity> customClass, EntityType.EntityFactory customMob) {
        this.name = name;
        this.customClass = customClass;
        this.customMob = customMob;
    }

    public static void registerEntities() {
        Map<String, Type<?>> types = (Map<String, Type<?>>) DataFixers.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getCurrentVersion().getWorldVersion())).findChoiceType(References.ENTITY).types();
        unfreezeRegistry();
        CustomEntities_v1_19_R1[] entities = CustomEntities_v1_19_R1.values();
        for (CustomEntities_v1_19_R1 entity : entities) {
            entity.setCustomEntityType(registerEntity(entity.getName(), entity.getCustomMob(), types));
        }
        Registry.ENTITY_TYPE.freeze();
    }

    private static EntityType<Entity> registerEntity(String type, EntityType.EntityFactory customMob, Map<String, Type<?>> types) {
        if (Registry.ENTITY_TYPE.getOptional(new ResourceLocation(type)).isEmpty()) {
            String customName = "minecraft:realisticsurvival_" + type;
            types.put(customName, types.get("minecraft:" + type));
            EntityType.Builder<Entity> a = EntityType.Builder.of(customMob, MobCategory.MONSTER);
            return Registry.register(Registry.ENTITY_TYPE, customName, a.build(customName));
        }
        return null;
    }

    private static void unfreezeRegistry() {
        Class<MappedRegistry> registryClass = MappedRegistry.class;
        try {
            Field intrusiveHolderCache = registryClass.getDeclaredField(ObfuscatedFields_v1_19_R1.INTRUSIVE_HOLDER_CACHE_SYMBOL);
            intrusiveHolderCache.setAccessible(true);
            intrusiveHolderCache.set(Registry.ENTITY_TYPE, new IdentityHashMap<EntityType<?>, Holder.Reference<EntityType<?>>>());
            Field frozen = registryClass.getDeclaredField(ObfuscatedFields_v1_19_R1.FROZEN_SYMBOL);
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

    public Class<? extends Entity> getCustomClass() {
        return customClass;
    }

    public EntityType.EntityFactory getCustomMob() {
        return customMob;
    }

    public EntityType<Entity> getCustomEntityType() {
        return customEntityType;
    }

    public void setCustomEntityType(EntityType<Entity> customEntityType) {
        this.customEntityType = customEntityType;
    }
}
