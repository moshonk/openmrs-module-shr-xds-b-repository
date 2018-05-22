package org.openmrs.module.xdsbrepository;

import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;

import static org.openmrs.module.xdsbrepository.XDSbServiceConstants.XDS_REPOSITORY_LOCATION_LOOKUP_ATTRIBUTE_TYPE;

public class Utils {

    /**
     * Start an OpenMRS Session
     */
    public static void startSession() {
        AdministrationService as = Context.getAdministrationService();
        Context.openSession();

        if (!Context.isAuthenticated()) {
            String username = as.getGlobalProperty(XDSbServiceConstants.WS_USERNAME_GP);
            String password = as.getGlobalProperty(XDSbServiceConstants.WS_PASSWORD_GP);
            Context.authenticate(username, password);
        }
    }

    public static String getLocationLookupAttributeTypeUuid() {
        return getProperty(XDS_REPOSITORY_LOCATION_LOOKUP_ATTRIBUTE_TYPE, "6242bf19-207e-4076-9d28-9290525b8ed9");
    }

    private static String getProperty(String name, String defaultVal) {
        return Context.getAdministrationService().getGlobalProperty(name, defaultVal);
    }

}
