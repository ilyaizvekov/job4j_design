package ru.job4j.generic;

import ru.job4j.generics.MemStore;
import ru.job4j.generics.Role;
import ru.job4j.generics.Store;

public class RoleStore implements Store<Role> {

    private final Store<Role> role = new MemStore<>();

    @Override
    public void add(Role model) {
        role.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return role.replace(id, model);
    }

    @Override
    public void delete(String id) {
        role.delete(id);
    }

    @Override
    public Role findById(String id) {
        return role.findById(id);
    }
}
