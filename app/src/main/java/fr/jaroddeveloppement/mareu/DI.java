package fr.jaroddeveloppement.mareu;

import fr.jaroddeveloppement.mareu.service.ApiService;
import fr.jaroddeveloppement.mareu.service.DummyApiService;

/**
     * Dependency injector to get instance of services
     */
    public class DI {

        private static ApiService service = new DummyApiService();

        /**
         * Get an instance on @{@link DummyApiService}
         * @return
         */
        public static ApiService getApiService() {
            return service;
        }

        /**
         * Get always a new instance on @{@link }. Useful for tests, so we ensure the context is clean.
         * @return
         */
        public static ApiService getNewInstanceApiService() {
            return new DummyApiService();
        }
    }

