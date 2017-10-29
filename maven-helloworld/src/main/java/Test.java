/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
import org.kodejava.example.RetConfig;

import java.util.List;

/**
 * Test.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class Test {
    public static List retSalesShipOem(String queryInput) {
        System.out.println(RetConfig.retConfig("url"));
        System.out.println(RetConfig.retConfig("user"));
        System.out.println(RetConfig.retConfig("password"));
        return null;
    }

    public static void main(String[] args) {
        retSalesShipOem(null);
    }
}
