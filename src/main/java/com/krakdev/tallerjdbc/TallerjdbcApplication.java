package com.krakdev.tallerjdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.krakdev.jdbc.*;

@SpringBootApplication
public class TallerjdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TallerjdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
                InsertVehiculo.insertar("ABC-1234", "Toyota", "Corolla", 2022, 21500.50, "Rojo", true, 15000);

        SelectVehiculo.listar();

        UpdateVehiculo.actualizar("ABC-1234", 20000.00, false, 18000);

        SelectVehiculo.listar();

    }
}