package baiTap1.Bai8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    static List<Country> listCountry = new ArrayList<>();
    static List<City> listCity = new ArrayList<>();
    static Set<String> setCodeContinent = new HashSet<>();

    private static List<Country> ArrCountry() {
        try {
            FileReader fileReaderCountry = new FileReader("E:\\new_code\\baiTap\\input_8\\countries.dat");
            BufferedReader bufferedReaderCountry = new BufferedReader(fileReaderCountry);
            String lineCountry = null;
            while ((lineCountry = bufferedReaderCountry.readLine()) != null) {
                String[] lS = lineCountry.split("[a-zA-Z{]+=|,\\s[a-zA-Z]+=|}$");
                Country country = new Country(lS[1], lS[2], lS[3], Double.parseDouble(lS[4]), Integer.parseInt(lS[5]), Double.parseDouble(lS[6]), Integer.parseInt(lS[7]));
                listCountry.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Country country : listCountry) {
            setCodeContinent.add(country.getContinent());
        }

        return listCountry;
    }

    private static List<City> ArrCity() {
        try {
            FileReader fileReaderCity = new FileReader("E:\\new_code\\baiTap\\input_8\\cities.dat");
            BufferedReader bufferedReaderCity = new BufferedReader(fileReaderCity);
            String lineCity = null;
            while ((lineCity = bufferedReaderCity.readLine()) != null) {
                String[] lS = lineCity.split("[a-zA-Z{]+=|,\\s[a-zA-Z]+=|]$");
                City city = new City(Integer.parseInt(lS[1]), lS[2], Integer.parseInt(lS[3]), lS[4]);
                listCity.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCity;
    }

    private static void ArrContinent() {

    }


    private static void assignment1() {
        for (Country country : listCountry) {
            int a = 0;
            String nameCity = "";
            for (City city : listCity) {
                if (country.getCode().equals(city.getCountryCode()) && city.getPopulation() > a) {
                    a = city.getPopulation();
                    nameCity = city.getName();
                }
            }
            System.out.println("tên nước:" + country.getName() + "      thành phố:" + nameCity + "      dân số:" + a);
        }
    }


    private static void assignment2() {
        for (String codeContinent : setCodeContinent) {
            int b = 0;
            String nameCountry = "";
            String nameCity = "";
            for (Country country : listCountry) {
                if (codeContinent.equals(country.getContinent())) {
                    for (City city : listCity) {
                        if (country.getCode().equals(city.getCountryCode()) && city.getPopulation() > b) {
                            b = city.getPopulation();
                            nameCity = city.getName();
                            nameCountry = country.getName();
                        }
                    }

                }
            }
            System.out.println("mã lục địa:" + codeContinent + "      tên nước:" + nameCountry + "      thành phố:" + nameCity + "      dân số:" + b);
        }
    }


    private static void assignment3() {
        int c = 0;
        String nameCountry = "";
        String nameCity = "";
        for (Country country : listCountry) {
            for (City city : listCity) {
                if (country.getCapital() == city.getId() && city.getPopulation() > c) {
                    c = city.getPopulation();
                    nameCity = city.getName();
                    nameCountry = country.getName();
                }
            }
        }
        System.out.println("tên nước:" + nameCountry + "      thành phố:" + nameCity + "      dân số:" + c);
    }


    private static void assignment4() {
//        for (String codeContinent : setCodeContinent) {
//            int d = 0;
//            String nameCountry = "";
//            String nameCity = "";
//            for (Country country : listCountry) {
//                if (codeContinent.equals(country.getContinent())) {
//                    for (City city : listCity) {
//                        if (country.getCapital() == city.getId() && city.getPopulation() > d) {
//                            d = city.getPopulation();
//                            nameCity = city.getName();
//                            nameCountry = country.getName();
//                        }
//                    }
//                }
//            }
//            System.out.println("mã lục địa:" + codeContinent + "      tên nước:" + nameCountry + "      thành phố:" + nameCity + "      dân số:" + d);
//        }

        setCodeContinent.forEach(codeContinent ->{
            AtomicInteger d = new AtomicInteger();
            AtomicReference<String> nameCountry = new AtomicReference<>("");
            AtomicReference<String> nameCity = new AtomicReference<>("");
            listCountry.forEach(country -> {
                if (codeContinent.equals(country.getContinent())) {
                    listCity.forEach(city -> {
                        if (country.getCapital() == city.getId() && city.getPopulation() > d.get()) {
                            d.set(city.getPopulation());
                            nameCity.set(city.getName());
                            nameCountry.set(country.getName());
                        }
                    });
                }
            });
        });
    }


    private static void assignment5() {
        listCountry.forEach(country -> {
            int a = (int) listCity.stream().filter(city -> country.getCode().equals(city.getCountryCode())).count();
            country.setNumberCity(a);
        });

        listCountry.sort((o1, o2) -> {
                    return o2.getNumberCity() - o1.getNumberCity();
                }
        );
        listCountry.forEach((country) -> {
            System.out.println("tên nước:" + country.getName() + "      số thành phố: " + country.getNumberCity());
        });
    }


    private static void assignment6() {
        listCountry.sort((o1, o2) -> {
                    return (int) (o2.getPopulation() / o2.getSurfaceArea() - o1.getPopulation() / o1.getSurfaceArea());
                }
        );
        listCountry.forEach((country) -> {
            if (country.getPopulation() != 0) {
                System.out.println("tên nước:" + country.getName() + "      mật độ dân số: " + country.getPopulation() / country.getSurfaceArea());
            }
        });
    }

    public static void main(String[] args) {
        ArrCountry();
        ArrCity();
//        assignment1();
//        assignment2();
//        assignment3();
//        assignment4();
        assignment5();
//        assignment6();
    }
}
