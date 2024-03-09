package ru.job4j.generic;

import org.junit.jupiter.api.Test;
import ru.job4j.generics.Role;
import ru.job4j.generics.User;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsSeller() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        Role result = role.findById("1");
        assertThat(result.getRole()).isEqualTo("Seller");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        Role result = role.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsSeller() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        role.add(new Role("1", "Teller"));
        Role result = role.findById("1");
        assertThat(result.getRole()).isEqualTo("Seller");
    }

    @Test
    void whenReplaceThenRoleNameIsSeller() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        role.replace("1", new Role("1", "Teller"));
        Role result = role.findById("1");
        assertThat(result.getRole()).isEqualTo("Teller");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        role.replace("10", new Role("10", "Teller"));
        Role result = role.findById("1");
        assertThat(result.getRole()).isEqualTo("Seller");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        role.delete("1");
        Role result = role.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsSeller() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        role.delete("10");
        Role result = role.findById("1");
        assertThat(result.getRole()).isEqualTo("Seller");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        boolean result = role.replace("1", new Role("1", "Teller"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Seller"));
        boolean result = role.replace("10", new Role("10", "Teller"));
        assertThat(result).isFalse();
    }

}