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
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.util.Map;

public enum CustomEntities_v1_16_R4 {

    ENDERMAN_ALLY("enderman_ally", EntityType.ENDERMAN.getTypeId(), EntityType.ENDERMAN, EntityEnderman.class, EndermanAlly_v1_16_R4.class),
    FIRE_DRAGON("fire_dragon", EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EntityEnderDragon.class, FireDragon_v1_16_R4.class),
    ICE_DRAGON("ice_dragon", EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EntityEnderDragon.class, IceDragon_v1_16_R4.class),
    LIGHTNING_DRAGON("lightning_dragon", EntityType.ENDER_DRAGON.getTypeId(), EntityType.ENDER_DRAGON, EntityEnderDragon.class, LightningDragon_v1_16_R4.class),
    SEA_SERPENT("sea_serpent", EntityType.ELDER_GUARDIAN.getTypeId(), EntityType.ELDER_GUARDIAN, EntityGuardianElder.class, SeaSerpent_v1_16_R4.class),
    SIREN("siren", EntityType.GUARDIAN.getTypeId(), EntityType.GUARDIAN, EntityGuardian.class, Siren_v1_16_R4.class);

    private final String name;
    private final int id;
    private final EntityType entityType;
    private final MinecraftKey minecraftKey;
    private final Class<? extends EntityInsentient> nmsClass;
    private final Class<? extends Entity> customClass;

    CustomEntities_v1_16_R4(String name, int id, EntityType entityType, Class<? extends EntityInsentient> nmsClass,
                            Class<? extends Entity> customClass) {
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.minecraftKey = new MinecraftKey(name);
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }

    public static void registerEntities() {
        Map<String, Type<?>> types = (Map<String, Type<?>>) DataConverterRegistry.a().getSchema(DataFixUtils.makeKey(SharedConstants.getGameVersion().getWorldVersion())).findChoiceType(DataConverterTypes.ENTITY).types();
        registerEntity("fire_dragon", FireDragon_v1_16_R4::new, types);
        registerEntity("ice_dragon", IceDragon_v1_16_R4::new, types);
        registerEntity("lightning_dragon", LightningDragon_v1_16_R4::new, types);
        registerEntity("enderman_ally", EndermanAlly_v1_16_R4::new, types);
        registerEntity("sea_serpent", SeaSerpent_v1_16_R4::new, types);
        registerEntity("siren", Siren_v1_16_R4::new, types);
    }

    private static void registerEntity(String type, EntityTypes.b customMob, Map<String, Type<?>> types) {
        if (IRegistry.ENTITY_TYPE.getOptional(new MinecraftKey(type)).isEmpty()) {
            String customName = "minecraft:realisticsurvival_" + type;
            types.put(customName, types.get("minecraft:" + type));
            EntityTypes.Builder<Entity> a = EntityTypes.Builder.a(customMob, EnumCreatureType.MONSTER);
            IRegistry.a(IRegistry.ENTITY_TYPE, customName, a.a(customName));
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

    public EntityType getEntityTypes() {
        return entityType;
    }

    public MinecraftKey getMinecraftKey() {
        return minecraftKey;
    }

    public Class<? extends EntityInsentient> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends Entity> getCustomClass() {
        return customClass;
    }

}
