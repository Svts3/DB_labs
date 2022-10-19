package ua.lviv.iot.view;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.lviv.iot.controller.impl.CityControllerImpl;
import ua.lviv.iot.controller.impl.CountryControllerImpl;
import ua.lviv.iot.controller.impl.EmergencyPhoneNumberControllerImpl;
import ua.lviv.iot.controller.impl.HealthInfoControllerImpl;
import ua.lviv.iot.controller.impl.OwnerControllerImpl;
import ua.lviv.iot.controller.impl.PropertyInfoControllerImpl;
import ua.lviv.iot.controller.impl.RegionControllerImpl;
import ua.lviv.iot.controller.impl.StreetControllerImpl;
import ua.lviv.iot.controller.impl.UserControllerImpl;
import ua.lviv.iot.controller.impl.WatchBatteryControllerImpl;
import ua.lviv.iot.controller.impl.WatchControllerImpl;
import ua.lviv.iot.controller.impl.WatchLocationControllerImpl;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.EmergencyPhoneNumber;
import ua.lviv.iot.model.HealthInfo;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.PropertyInfo;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.model.Street;
import ua.lviv.iot.model.User;
import ua.lviv.iot.model.Watch;
import ua.lviv.iot.model.WatchBattery;
import ua.lviv.iot.model.WatchLocation;

@Component
public class View {

    Scanner scanner = new Scanner(System.in);

    Map<String, String> menu;
    Map<String, Printable> menuMethods;

    private UserControllerImpl userControllerImpl;
    private OwnerControllerImpl ownerControllerImpl;
    private PropertyInfoControllerImpl propertyInfoControllerImpl;
    private WatchControllerImpl watchControllerImpl;
    private HealthInfoControllerImpl healthInfoControllerImpl;
    private WatchLocationControllerImpl watchLocationControllerImpl;
    private WatchBatteryControllerImpl batteryControllerImpl;
    private EmergencyPhoneNumberControllerImpl emergencyPhoneNumberControllerImpl;
    private CountryControllerImpl countryControllerImpl;
    private RegionControllerImpl regionControllerImpl;
    private CityControllerImpl cityControllerImpl;
    private StreetControllerImpl streetControllerImpl;

    @Autowired
    public View(UserControllerImpl userControllerImpl, OwnerControllerImpl ownerControllerImpl,
            PropertyInfoControllerImpl propertyInfoControllerImpl,
            WatchControllerImpl watchControllerImpl,
            HealthInfoControllerImpl healthInfoControllerImpl,
            WatchLocationControllerImpl watchLocationControllerImpl,
            WatchBatteryControllerImpl batteryControllerImpl,
            EmergencyPhoneNumberControllerImpl emergencyPhoneNumberControllerImpl,
            CountryControllerImpl countryControllerImpl, RegionControllerImpl regionControllerImpl,
            CityControllerImpl cityControllerImpl, StreetControllerImpl streetControllerImpl) {
        this.userControllerImpl = userControllerImpl;
        this.ownerControllerImpl = ownerControllerImpl;
        this.propertyInfoControllerImpl = propertyInfoControllerImpl;
        this.watchControllerImpl = watchControllerImpl;
        this.healthInfoControllerImpl = healthInfoControllerImpl;
        this.watchLocationControllerImpl = watchLocationControllerImpl;
        this.batteryControllerImpl = batteryControllerImpl;
        this.emergencyPhoneNumberControllerImpl = emergencyPhoneNumberControllerImpl;
        this.countryControllerImpl = countryControllerImpl;
        this.regionControllerImpl = regionControllerImpl;
        this.cityControllerImpl = cityControllerImpl;
        this.streetControllerImpl = streetControllerImpl;
        
        
        
        
        menu = new LinkedHashMap<>();
        menu.put("A", "A - select all tables");

        menu.put("1", "1 - Table: Owner");
        menu.put("11", "11 - Create Owner");
        menu.put("12", "12 - Update Owner");
        menu.put("13", "13 - Delete Owner");
        menu.put("14", "14 - Find all Owners");
        menu.put("15", "15 - Find owner by ID");
        menu.put("16", "16 - Find owners by first name");
        menu.put("17", "17 - Find owners by last name");

        menu.put("2", "2 - Table: Watch");
        menu.put("21", "21 - Create Watch");
        menu.put("22", "22 - Update Watch");
        menu.put("23", "23 - Delete Watch");
        menu.put("24", "24 - Find watch by serial number");
        menu.put("25", "25 - Find all watches");

        menu.put("3", "3 - Table: PropertyInfo");
        menu.put("31", "31 - Create PropertyInfo");
        menu.put("32", "32 - Delete PropertyInfo");
        menu.put("33", "33 - Update PropertyInfo");
        menu.put("34", "34 - Find PropertyInfo by id");
        menu.put("35", "35 - Find all PropertyInfos");

        menu.put("4", "4 - Table: User");
        menu.put("41", "41 - Create User");
        menu.put("42", "42 - Update User");
        menu.put("43", "43 - Delete User");
        menu.put("44", "44 - Find all Users");
        menu.put("45", "45 - Find User by ID");
        menu.put("46", "46 - Find Users by first name");
        menu.put("47", "47 - Find Users by last name");

        menu.put("5", "5 - Table: HealthInfo");
        menu.put("51", "51 - Create HealthInfo");
        menu.put("52", "52 - Update HealthInfo");
        menu.put("53", "53 - Delete HealthInfo");
        menu.put("54", "54 - Select everything from HealthInfo");
        menu.put("55", "55 - Find HealthInfo by ID");

        menu.put("6", "6 - Table: WatchLocation");
        menu.put("61", "61 - Create WatchLocation");
        menu.put("62", "62 - Update WatchLocation");
        menu.put("63", "63 - Delete WatchLocation");
        menu.put("64", "64 - Select everything from HealthInfo");
        menu.put("65", "65 - Find WatchLocation by ID");

        menu.put("7", "7 - Table: WatchBattery");
        menu.put("71", "71 - Create WatchBattery");
        menu.put("72", "72 - Update WatchBattery");
        menu.put("73", "73 - Delete WatchBattery");
        menu.put("74", "74 - Select everything from WatchBattery");
        menu.put("75", "75 - Find WatchBattery by ID");

        menu.put("8", "8 - Table: EmergencyPhoneNumber");
        menu.put("81", "81 - Create EmergencyPhoneNumber");
        menu.put("82", "82 - Update EmergencyPhoneNumber");
        menu.put("83", "83 - Delete EmergencyPhoneNumber");
        menu.put("84", "84 - Select everything from EmergencyPhoneNumber");
        menu.put("85", "85 - Find EmergencyPhoneNumber by ID");

        menu.put("9", "9 - Table: Country");
        menu.put("91", "91 - Create Country");
        menu.put("92", "92 - Update Country");
        menu.put("93", "93 - Delete Country");
        menu.put("94", "94 - Find all countries");
        menu.put("95", "95 - Find country by name");

        menu.put("100", "100 - Table: Region");
        menu.put("101", "101 - Create Region");
        menu.put("102", "102 - Update Region");
        menu.put("103", "103 - Delete Region");
        menu.put("104", "104 - Find region by name");
        menu.put("105", "105 - Find all regions");

        menu.put("110", "110 - Table: City");
        menu.put("111", "111 - Create City");
        menu.put("112", "112 - Update City");
        menu.put("113", "113 - Delete City");
        menu.put("114", "114 - Find all cities");
        menu.put("115", "115 - Find city by name");

        menu.put("120", "120 - Table: Street");
        menu.put("121", "121 - Create Street");
        menu.put("122", "122 - Update Street");
        menu.put("123", "123 - Delete Street");
        menu.put("124", "124 - Find all streets");
        menu.put("125", "125 - Find street by name");

        menu.put("Q", "Q - Exit");
        
        menuMethods = new LinkedHashMap<>();
        
        menuMethods.put("A", this::findAllTables);
        menuMethods.put("11", this::createOwner);
        menuMethods.put("12", this::updateOwner);
        menuMethods.put("13", this::deleteOwner);
        menuMethods.put("14", this::findAllOwners);
        menuMethods.put("15", this::findOwnerById);
        menuMethods.put("16", this::findOwnersByFirstName);
        menuMethods.put("17", this::findOwnersByLastName);

        menuMethods.put("21", this::createWatch);
        menuMethods.put("22", this::updateWatch);
        menuMethods.put("23", this::deleteWatch);
        menuMethods.put("24", this::findWatchBySerialNumber);
        menuMethods.put("25", this::findAllWatches);

        menuMethods.put("31", this::createPropertyInfo);
        menuMethods.put("32", this::updatePropertyInfo);
        menuMethods.put("33", this::deletePropertyInfo);
        menuMethods.put("34", this::findPropertyInfoById);
        menuMethods.put("35", this::findAllPropertyInfos);

        menuMethods.put("41", this::createUser);
        menuMethods.put("42", this::updateUser);
        menuMethods.put("43", this::deleteUser);
        menuMethods.put("44", this::findAllUsers);
        menuMethods.put("45", this::findUserById);
        menuMethods.put("46", this::findUsersByFirstName);
        menuMethods.put("46", this::findUsersByLastName);

        menuMethods.put("51", this::createHealthInfo);
        menuMethods.put("52", this::updateHealthInfo);
        menuMethods.put("53", this::deleteHealthInfo);
        menuMethods.put("54", this::findAllHealthInfos);
        menuMethods.put("55", this::findHealthInfoById);

        menuMethods.put("61", this::createWatchLocation);
        menuMethods.put("62", this::updateWatchLocation);
        menuMethods.put("63", this::deleteWatchLocation);
        menuMethods.put("64", this::findAllWatchLocation);
        menuMethods.put("65", this::findWatchLocationById);

        menuMethods.put("71", this::createWatchBattery);
        menuMethods.put("72", this::updateWatchBattery);
        menuMethods.put("73", this::deleteWatchBattery);
        menuMethods.put("74", this::findAllWatchBatteries);
        menuMethods.put("75", this::findWatchBatteryById);

        menuMethods.put("81", this::createEmergencyPhoneNumber);
        menuMethods.put("82", this::updateEmergencyPhoneNumber);
        menuMethods.put("83", this::deleteEmergencyPhoneNumber);
        menuMethods.put("84", this::findAllEmergencyPhoneNumbers);
        menuMethods.put("85", this::findEmergencyPhoneNumberById);

        menuMethods.put("91", this::createCountry);
        menuMethods.put("92", this::updateCountry);
        menuMethods.put("93", this::deleteCountry);
        menuMethods.put("94", this::findAllCountries);
        menuMethods.put("95", this::findByCountryName);

        menuMethods.put("101", this::createRegion);
        menuMethods.put("102", this::updateRegion);
        menuMethods.put("103", this::deleteRegion);
        menuMethods.put("104", this::findByRegionName);
        menuMethods.put("105", this::findAllRegions);

        menuMethods.put("111", this::createCity);
        menuMethods.put("112", this::updateCity);
        menuMethods.put("113", this::deleteCity);
        menuMethods.put("114", this::findAllCities);
        menuMethods.put("115", this::findByCityName);

        menuMethods.put("121", this::createStreet);
        menuMethods.put("122", this::updateStreet);
        menuMethods.put("123", this::deleteStreet);
        menuMethods.put("124", this::findAllStreets);
        menuMethods.put("125", this::findByStreetName);

    }


    public void findAllTables() {
        findAllOwners();
        findAllCities();
        findAllCountries();
        findAllEmergencyPhoneNumbers();
        findAllHealthInfos();
        findAllPropertyInfos();
        findAllRegions();
        findAllStreets();
        findAllUsers();
        findAllWatchBatteries();
        findAllWatches();
        findAllWatchLocation();
    }

    // OWNER
    public void createOwner() {
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        System.out.println("Input 'date of birth': ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Input 'gender': ");
        String gender = scanner.nextLine();

        Owner owner = new Owner(null, firstName, lastName, dateOfBirth, gender);
        int count = ownerControllerImpl.save(owner);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateOwner() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        System.out.println("Input 'date of birth': ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Input 'gender': ");
        String gender = scanner.nextLine();
        Owner owner = new Owner(null, firstName, lastName, dateOfBirth, gender);
        int count = ownerControllerImpl.update(owner, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteOwner() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = ownerControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);

    }

    public void findOwnerById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println(ownerControllerImpl.findById(id));
    }

    public void findAllOwners() {
        System.out.println("Owners: \n");
        List<Owner> owners = this.ownerControllerImpl.findAll();
        owners.forEach((n) -> System.out.println(n));
    }

    public void findOwnersByFirstName() {
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        List<Owner> owners = ownerControllerImpl.findOwnersByFirstName(firstName);
        owners.forEach((n) -> System.out.println(n));
    }

    public void findOwnersByLastName() {
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        List<Owner> owners = ownerControllerImpl.findOwnersByLastName(lastName);
        owners.forEach((n) -> System.out.println(n));
    }

    // WATCH
    public void findWatchBySerialNumber() {
        System.out.println("Input 'serial number': ");
        String serialNumber = scanner.nextLine();

        System.out.println(watchControllerImpl.findWatchBySerialNumber(serialNumber));
    }

    public void findAllWatches() {
        System.out.println("Watch:\n");
        List<Watch> watches = watchControllerImpl.findAll();
        watches.forEach((n) -> System.out.println(n));
    }

    public void createWatch() {
        System.out.println("Input 'serial number': ");
        String serialNumber = scanner.nextLine();
        System.out.println("Input 'street name': ");
        String streetName = scanner.nextLine();

        Watch watch = new Watch(serialNumber, streetName);
        int count = watchControllerImpl.save(watch);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateWatch() {
        System.out.println("Input 'serial number': ");
        String serialNumber = scanner.nextLine();
        System.out.println("Input 'street name': ");
        String streetName = scanner.nextLine();
        Watch watch = new Watch(serialNumber, streetName);
        int count = watchControllerImpl.update(watch, serialNumber);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteWatch() {
        System.out.println("Input 'serial number': ");
        String serialNumber = scanner.nextLine();
        int count = watchControllerImpl.deleteById(serialNumber);
        System.out.printf("There are created %d rows\n", count);
    }

    // PROPERTY INFO

    public void findAllPropertyInfos() {
        System.out.println("PropertyInfo: \n");
        List<PropertyInfo> infos = propertyInfoControllerImpl.findAll();
        infos.forEach((n) -> System.out.println(n));
    }

    public void findPropertyInfoById() {
        System.out.println("Input 'owner ID': ");
        Long ownerId = scanner.nextLong();
        System.out.println(propertyInfoControllerImpl.findById(ownerId));
    }

    public void createPropertyInfo() {
        System.out.println("Input 'owner ID': ");
        Long ownerId = scanner.nextLong();
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();

        PropertyInfo propertyInfo = new PropertyInfo(null, ownerId, serialNumber);
        int count = propertyInfoControllerImpl.save(propertyInfo);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updatePropertyInfo() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'owner ID': ");
        Long ownerId = scanner.nextLong();
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();
        PropertyInfo propertyInfo = new PropertyInfo(null, ownerId, serialNumber);
        int count = propertyInfoControllerImpl.update(propertyInfo, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deletePropertyInfo() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = propertyInfoControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);
    }

    // User

    public void findAllUsers() {
        System.out.println("Users: \n");
        List<Owner> owners = this.ownerControllerImpl.findAll();
        owners.forEach((n) -> System.out.println(n));
    }

    public void findUserById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        System.out.println(userControllerImpl.findById(id));
    }

    public void findUsersByFirstName() {
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        List<User> users = userControllerImpl.findUsersByFirstName(firstName);
        users.forEach((n) -> System.out.println(n));
    }

    public void findUsersByLastName() {
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        List<User> users = userControllerImpl.findUsersByLastName(lastName);
        users.forEach((n) -> System.out.println(n));
    }

    public void createUser() {
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        System.out.println("Input 'date of birth': ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Input 'gender': ");
        String gender = scanner.nextLine();
        System.out.println("Input 'property info id': ");
        Long propertyInfoId = scanner.nextLong();

        User user = new User(null, firstName, lastName, dateOfBirth, gender, propertyInfoId);
        int count = userControllerImpl.save(user);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateUser() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'first name': ");
        String firstName = scanner.nextLine();
        System.out.println("Input 'last name': ");
        String lastName = scanner.nextLine();
        System.out.println("Input 'date of birth': ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Input 'gender': ");
        String gender = scanner.nextLine();
        System.out.println("Input 'property info id': ");
        Long propertyInfoId = scanner.nextLong();

        User user = new User(null, firstName, lastName, dateOfBirth, gender, propertyInfoId);
        int count = userControllerImpl.update(user, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteUser() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = userControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);

    }

    // HealthInfo

    public void findAllHealthInfos() {
        System.out.println("HealthInfo: \n");
        List<HealthInfo> healthInfos = healthInfoControllerImpl.findAll();
        healthInfos.forEach((n) -> System.out.println(n));
    }

    public void findHealthInfoById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println(healthInfoControllerImpl.findById(id));
    }

    public void createHealthInfo() {
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();
        System.out.println("Input 'heartbeat rate': ");
        Integer hearbeatRate = scanner.nextInt();

        HealthInfo healthInfo = new HealthInfo(null, hearbeatRate, serialNumber);
        int count = healthInfoControllerImpl.save(healthInfo);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateHealthInfo() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'heartbeat rate': ");
        Integer hearbeatRate = scanner.nextInt();
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();

        HealthInfo healthInfo = new HealthInfo(null, hearbeatRate, serialNumber);
        int count = healthInfoControllerImpl.update(healthInfo, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteHealthInfo() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        int count = healthInfoControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);
    }

    // WatchLocation

    public void findAllWatchLocation() {
        System.out.println("WatchLocation:\n");
        System.out.println(watchLocationControllerImpl.findAll());
    }

    public void findWatchLocationById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        System.out.println(watchLocationControllerImpl.findById(id));
    }

    public void createWatchLocation() {
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();
        System.out.println("Input 'latitude': ");
        Double latitude = scanner.nextDouble();
        System.out.println("Input 'watch longitude': ");
        Double longitude = scanner.nextDouble();

        WatchLocation watchLocation = new WatchLocation(null, latitude, longitude, serialNumber);
        int count = watchLocationControllerImpl.save(watchLocation);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateWatchLocation() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'latitude': ");
        Double latitude = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input 'watch longitude': ");
        Double longitude = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input 'watch serial number': ");
        String serialNumber = scanner.nextLine();

        WatchLocation watchLocation = new WatchLocation(null, latitude, longitude, serialNumber);
        int count = watchLocationControllerImpl.update(watchLocation, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteWatchLocation() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = watchLocationControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);
    }

    // watchBattery

    public void findAllWatchBatteries() {
        System.out.println("Watch battery: \n");
        List<WatchBattery> watchBatteries = batteryControllerImpl.findAll();
        watchBatteries.forEach((n) -> System.out.println(n));
    }

    public void findWatchBatteryById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println(batteryControllerImpl.findById(id));
    }

    public void createWatchBattery() {
        System.out.println("Input 'watch serial number': ");
        String watchSerialNumber = scanner.nextLine();
        System.out.println("Input 'charge level': ");
        Integer chargeLevel = scanner.nextInt();

        WatchBattery battery = new WatchBattery(null, chargeLevel, watchSerialNumber);
        int count = batteryControllerImpl.save(battery);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateWatchBattery() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'watch serial number': ");
        scanner.next();
        String watchSerialNumber = scanner.nextLine();
        System.out.println("Input 'charge level': ");
        Integer chargeLevel = scanner.nextInt();

        WatchBattery battery = new WatchBattery(null, chargeLevel, watchSerialNumber);
        int count = batteryControllerImpl.update(battery, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteWatchBattery() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = batteryControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);
    }

    // Emergency phone number

    public void findAllEmergencyPhoneNumbers() {
        System.out.println("EmergencyPhoneNumber: \n");
        List<EmergencyPhoneNumber> phoneNumbers = emergencyPhoneNumberControllerImpl.findAll();
        phoneNumbers.forEach((n) -> System.out.println(n));
    }

    public void findEmergencyPhoneNumberById() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println(emergencyPhoneNumberControllerImpl.findById(id));
    }

    public void createEmergencyPhoneNumber() {
        System.out.println("Input 'watch serial number': ");
        String watchSerialNumber = scanner.nextLine();
        System.out.println("Input 'phone number': ");
        String phoneNumber = scanner.nextLine();

        EmergencyPhoneNumber emergencyPhoneNumber = new EmergencyPhoneNumber(null, phoneNumber,
                watchSerialNumber);
        int count = emergencyPhoneNumberControllerImpl.save(emergencyPhoneNumber);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateEmergencyPhoneNumber() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();
        System.out.println("Input 'watch serial number': ");
        String watchSerialNumber = scanner.nextLine();
        System.out.println("Input 'phone number': ");
        String phoneNumber = scanner.nextLine();

        EmergencyPhoneNumber emergencyPhoneNumber = new EmergencyPhoneNumber(null, phoneNumber,
                watchSerialNumber);
        int count = emergencyPhoneNumberControllerImpl.update(emergencyPhoneNumber, id);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteEmergencyPhoneNumber() {
        System.out.println("Input 'ID': ");
        Long id = scanner.nextLong();

        int count = emergencyPhoneNumberControllerImpl.deleteById(id);
        System.out.printf("There are created %d rows\n", count);
    }

    // Country

    public void findAllCountries() {
        System.out.println("Contry:\n");
        List<Country> countries = countryControllerImpl.findAll();
        countries.forEach((n) -> System.out.println(n));
    }

    public void findByCountryName() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        System.out.println(countryControllerImpl.findCountryByName(name));
    }

    public void createCountry() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        Country country = new Country(name);
        int count = countryControllerImpl.save(country);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateCountry() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'new name': ");
        String updatedName = scanner.nextLine();

        Country country = new Country(updatedName);
        int count = countryControllerImpl.update(country, name);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteCountry() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        int count = countryControllerImpl.deleteById(name);
        System.out.printf("There are created %d rows\n", count);
    }

    // region
    public void findAllRegions() {
        System.out.println("Region:\n");
        List<Region> regions = regionControllerImpl.findAll();
        regions.forEach((n) -> System.out.println(n));
    }

    public void findByRegionName() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        System.out.println(regionControllerImpl.findRegionByName(name));
    }

    public void createRegion() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'country name': ");
        String countryName = scanner.nextLine();

        Region region = new Region(name, countryName);
        int count = regionControllerImpl.save(region);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateRegion() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        Country country = new Country(name);
        int count = countryControllerImpl.update(country, name);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteRegion() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        int count = regionControllerImpl.deleteById(name);
        System.out.printf("There are created %d rows\n", count);
    }

    // City
    public void findAllCities() {
        System.out.println("City:\n");
        List<City> cities = cityControllerImpl.findAll();
        cities.forEach((n) -> System.out.println(n));
    }

    public void findByCityName() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        System.out.println(cityControllerImpl.findCityByName(name));
    }

    public void createCity() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'city name': ");
        String regionName = scanner.nextLine();

        City city = new City(name, regionName);
        int count = cityControllerImpl.save(city);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateCity() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'region name': ");
        String regionName = scanner.nextLine();

        City city = new City(name, regionName);
        int count = cityControllerImpl.update(city, name);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteCity() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        int count = cityControllerImpl.deleteById(name);
        System.out.printf("There are created %d rows\n", count);
    }

    // Street

    public void findAllStreets() {
        System.out.println("Street:\n");
        List<Street> streets = streetControllerImpl.findAll();
        streets.forEach((n) -> System.out.println(n));
    }

    public void findByStreetName() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        System.out.println(streetControllerImpl.findStreetByName(name));
    }

    public void createStreet() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'city name': ");
        String cityName = scanner.nextLine();

        Street street = new Street(name, cityName);
        int count = streetControllerImpl.save(street);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateStreet() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();
        System.out.println("Input 'city name': ");
        String cityName = scanner.nextLine();

        Street street = new Street(name, cityName);
        int count = streetControllerImpl.update(street, name);
        System.out.printf("There are created %d rows\n", count);
    }

    public void deleteStreet() {
        System.out.println("Input 'name': ");
        String name = scanner.nextLine();

        int count = streetControllerImpl.deleteById(name);
        System.out.printf("There are created %d rows\n", count);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
            //if (key.length() == 1) {
                System.out.println(menu.get(key));
            //}
        }
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet()){
            if (key.length() >= 2 && key.substring(0, 4).equals(fig)){
                System.out.println(menu.get(key));
            }
        }

    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point:");
            keyMenu = scanner.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point:");
                keyMenu = scanner.nextLine().toUpperCase();
            }

            try {
                menuMethods.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
    
}