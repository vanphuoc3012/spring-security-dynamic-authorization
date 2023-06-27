package com.ph.dynamic.authorization;

import com.ph.dynamic.authorization.auth.Role;
import com.ph.dynamic.authorization.auth.role.type.CompanyRoleType;
import com.ph.dynamic.authorization.auth.role.type.GroupRoleType;
import com.ph.dynamic.authorization.auth.role.type.StoreRoleType;
import com.ph.dynamic.authorization.auth.role.type.SystemRoleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class RoleTest {

    @Test
    void shouldNotThrowStackOverflowException() {
        final var roots = Role.roots();
        final var existingRoles = Stream.concat(
                stream(GroupRoleType.values()),
                stream(StoreRoleType.values())
        ).collect(Collectors.toList());

        Assertions.assertDoesNotThrow(() -> {
            roots.forEach(root -> {
                existingRoles.forEach(roleToCheck -> {
                    Assertions.assertTrue(root.includes(roleToCheck));
                });
            });
        });
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    void shouldIncludeOrNotTHeGivenRoles(Role root, Set<Role> rolesToCheck, boolean expected) {
        for (Role role : rolesToCheck) {
            Assertions.assertEquals(expected, root.includes(role));
        }
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.arguments(
                        SystemRoleType.MASTER_ADMIN,
                        Stream.concat(
                                stream(CompanyRoleType.values()),
                                stream(StoreRoleType.values())
                        ).collect(Collectors.toSet()),
                        true
                ),
                Arguments.arguments(
                        StoreRoleType.MANAGER,
                        Stream.of(
                                StoreRoleType.EDITOR,
                                StoreRoleType.VIEWER,
                                GroupRoleType.EDITOR,
                                GroupRoleType.VIEWER
                        ).collect(Collectors.toSet()),
                        true
                ),
                Arguments.arguments(
                        GroupRoleType.VIEWER,
                        Stream.of(
                                GroupRoleType.EDITOR
                        ).collect(Collectors.toSet()),
                        false
                )
        );
    }
}
