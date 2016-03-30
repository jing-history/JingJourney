package com.jingzing;

import java.math.BigDecimal;

/**
 * Created by Louis Wang on 2016/3/22.
 */

    public class MyTest {
        public static void main(String[] args) {
//monthRate:0.006666667 borrowerRate:0.012500000 monthPay:666.67 borrowerPay:1250.00 platformPay:3499.9800000000005
            BigDecimal lv2 = new BigDecimal(0.15);   //利息 0.012500000 - 0.006666667 = 0.005833333
            BigDecimal lv3 = new BigDecimal(0.08);

            BigDecimal f07 = new BigDecimal(100000);    // 金额

            BigDecimal f07_2 = new BigDecimal(80000);    // 剩余金额
            int f09 = 6;    //月份
            BigDecimal monthRate = lv2.setScale(9,
                    BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(12),
                    9, BigDecimal.ROUND_HALF_UP);

            BigDecimal monthRate2 = lv3.setScale(9,
                    BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(12),
                    9, BigDecimal.ROUND_HALF_UP);

            BigDecimal monthPayTotal1 = debx(f07, monthRate, f09);
            BigDecimal monthPayTotal2 = debx(f07, monthRate2, f09);

            BigDecimal monthPayTotal3 = debx(f07_2, monthRate, f09);
            BigDecimal monthPayTotal4 = debx(f07_2, monthRate2, f09);

            //利息
            BigDecimal interest = f07.multiply(monthRate).setScale(2,
                    BigDecimal.ROUND_HALF_UP);


            BigDecimal total = monthPayTotal1.subtract(monthPayTotal2).multiply(new BigDecimal(f09)).setScale(2,BigDecimal.ROUND_HALF_UP);

            BigDecimal total2 = monthPayTotal3.subtract(monthPayTotal4).multiply(new BigDecimal(f09)).setScale(2,BigDecimal.ROUND_HALF_UP);

            System.out.println("================bj:100000 yf:6 lv:0.15| bj:100000 yf:6 lv:0.08====================");
            System.out.println("total:" + total);  // 17403.38 - 17057.71 = 17008.59
            System.out.println("MyTest.main:" + total.divide(f07,9,BigDecimal.ROUND_HALF_UP));


            System.out.println("================bj:50000 yf:6 lv:0.15| bj:50000 yf:6 lv:0.08====================");
            System.out.println("total2:" + total2);  // 17403.38 - 17057.71 = 17008.59
            System.out.println("MyTest.main2:" + total.divide(f07,9,BigDecimal.ROUND_HALF_UP));
        }


        private static BigDecimal debx(BigDecimal total, BigDecimal monthRate, int terms) {
            BigDecimal tmp = monthRate.add(new BigDecimal(1)).pow(terms);//.setScale(9, BigDecimal.ROUND_HALF_UP);
        //    tmp = new BigDecimal(1.040672624868884);
//            System.out.println("MyTest.monthRate1:" + tmp);
//            System.out.println("MyTest.monthRate2:" + tmp.setScale(9, BigDecimal.ROUND_HALF_UP));
            return total
                    .multiply(monthRate)
                    .multiply(tmp)
                    .divide(tmp.subtract(new BigDecimal(1)), 2,
                            BigDecimal.ROUND_HALF_UP);
        }
    }
