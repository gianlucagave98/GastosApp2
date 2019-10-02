package com.ggave.gastosapp.repositories;

import com.ggave.gastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationsRepositoy {
    private static List<Operation> operations;

    static{
        operations = new ArrayList<>();
        operations.add(new Operation("10/04/2018", 1500, "Ahorro", "Ingreso"));
        operations.add(new Operation("10/04/2019", 2500, "Tarjeta de credito", "Ingreso"));
        operations.add(new Operation("10/04/2017", 4500, "Efectivo", "Ingreso"));
        operations.add(new Operation("10/04/2018", 1500, "Ahorro", "Ingreso"));

    }

    public static List<Operation> getOperations(){
        return operations;
    }


    public static void agregar(String fech, double mon, String tip_cuenta, String tip_operacion){
        operations.add( new Operation( fech, mon, tip_cuenta, tip_operacion));

    }

    public static double total(String saldo){
        double total = 0;
        double ingresos = 0;
        double egresos = 0;
        for (int i = 0; i<operations.size();i++){
            if(operations.get(i).getCuenta().equals(saldo)){
                if(operations.get(i).getOperacion().equals("Ingreso")){
                    double numero1 = operations.get(i).getMonto();
                    ingresos = ingresos + numero1;
                }else{
                    double numero2 = operations.get(i).getMonto();
                    egresos = egresos + numero2;
                }

            }
        }
        total = ingresos - egresos;
        return total;
    }
}
