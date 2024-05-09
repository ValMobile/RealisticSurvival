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
package me.val_mobile.rsv;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RSVPluginTest {

    private ServerMock server;
    private RSVPlugin plugin;

    @BeforeEach
    public void setUp()
    {
//        server = MockBukkit.mock();
//        plugin = MockBukkit.load(RSVPlugin.class);
    }

    @AfterEach
    public void tearDown()
    {
//        MockBukkit.unmock();
    }

    @Test
    public void test_module_enable() {
//        WorldMock world = server.addSimpleWorld("test_world");
//        FileConfiguration config = plugin.getConfig();
//
//        for (RSVModule module : RSVModule.getModules().values()) {
//            assert config.getBoolean(module.getName());
//            assert config.getBoolean(module.getName() + "." + world.getName());
//        }
    }
}
