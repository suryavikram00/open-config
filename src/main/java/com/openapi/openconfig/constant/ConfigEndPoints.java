/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openapi.openconfig.constant;

/**
 *
 * @author NMSLAP570
 */
public class ConfigEndPoints {

    public static final String ENDPOINT_V1_VERSION = "v1";
    public static final String ENDPOINT_V1_CRUD_HUB_PREFIX = "/" + ENDPOINT_V1_VERSION;
    public static final String ENDPOINT_CONFIG = ENDPOINT_V1_CRUD_HUB_PREFIX + "/config";
    public static final String ENDPOINT_USER = ENDPOINT_V1_CRUD_HUB_PREFIX + "/user";

}
