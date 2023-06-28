package com.ph.dynamic.authorization.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MenuController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc

class MenuControllerTest {

}

