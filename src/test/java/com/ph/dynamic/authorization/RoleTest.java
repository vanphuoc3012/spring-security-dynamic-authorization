package com.ph.dynamic.authorization;

import com.ph.dynamic.authorization.auth.Role;
import com.ph.dynamic.authorization.auth.role.RoleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleTest {

    @Test
    void shouldNotThrowStackOverflowException() {
        final var roots = Role.roots();
        final var existingRoles = Stream.of(RoleType.values());

        Assertions.assertDoesNotThrow(() -> {
            roots.forEach(root -> {
                System.out.println("Root: " + root);
                existingRoles.forEach(roleToCheck -> {
                    System.out.println(roleToCheck.name());
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
                        RoleType.MASTER_ADMIN,
                        Set.of(RoleType.MASTER_ADMIN,
                                RoleType.COMPANY_FULL_ACCESS, RoleType.COMPANY_EDITOR,
                                RoleType.COMPANY_VIEWER, RoleType.STORE_FULL_ACCESS,
                                RoleType.STORE_EDITOR, RoleType.STORE_VIEWER,
                                RoleType.GUEST),
                        true
                ),
                Arguments.arguments(
                        RoleType.STORE_FULL_ACCESS,
                        Set.of(RoleType.COMPANY_VIEWER, RoleType.COMPANY_EDITOR, RoleType.COMPANY_FULL_ACCESS, RoleType.MASTER_ADMIN),
                        false
                ),
                Arguments.arguments(
                        RoleType.COMPANY_VIEWER,
                        Set.of(RoleType.STORE_FULL_ACCESS, RoleType.STORE_EDITOR, RoleType.COMPANY_EDITOR),
                        false

                )
        );
    }
}
