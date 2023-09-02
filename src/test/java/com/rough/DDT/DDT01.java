package com.rough.DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT01 {




        @Test(dataProvider = "getMeData" )
        public void testForLogin(String email,String password, String status){
            System.out.println(email  + password  +status);
        }

        // Get the data from the Excel
        // One by one I have execute the TestFORlOGIN Method with the data

    @DataProvider(name = "getMeData")
    public Object[][] getMeDataForLogin(){

            return new Object[][]{
                    {"valid@gmail.com","Wingify@1234","Valid"},
                    {"invalid@gmail.com","Wingify@1234","InValid"}
            };
        }


}
