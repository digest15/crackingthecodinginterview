package tinkov_middle.collections.task3;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTask {

    public static void main(String[] args) {
        List<Client> clients = List.of(
                new Client(1, "Ivan", 10, List.of(new Phone("1", PhoneType.DIAL))),
                new Client(2, "Igor", 12, List.of(new Phone("2", PhoneType.MOBILE))),
                new Client(3, "Sasha", 12, List.of(new Phone("3", PhoneType.MOBILE))),
                new Client(4, "Dima", 18, List.of(new Phone("4", PhoneType.MOBILE))),
                new Client(5, "Vasia", 20, List.of(new Phone("5", PhoneType.DIAL))),
                new Client(6, "Vasia", 20, List.of(new Phone("55", PhoneType.DIAL))),
                new Client(7, "Sasha", 25, List.of(new Phone("6", PhoneType.DIAL))),
                new Client(8, "Michele", 30, List.of(new Phone("7", PhoneType.MOBILE))),
                new Client(12, "Jon", 35, List.of()),
                new Client(9, "Jon", 35, List.of(new Phone("8", PhoneType.DIAL))),
                new Client(10, "Genia", 36, List.of(new Phone("9", PhoneType.MOBILE))),
                new Client(11, "Genia", 37, List.of(new Phone("95", PhoneType.DIAL), new Phone("10", PhoneType.MOBILE)))
        );

        /*1. Рассчитать суммарный возраст для определенного имени.*/
        String name = "Vasia";
        int sum = clients.stream()
                .filter(client -> name.equals(client.name()))
                .mapToInt(Client::age)
                .sum();
        System.out.println(String.format("1. For name: %s, sum age: %s", name, sum));

        /*2. Получить Set, который содержит в себе только имена клиентов в порядке их упоминания в исходном массиве.*/
        Set<String> set = clients.stream()
                .map(client -> client.name)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("2. " + set);

        /*3. Узнать, содержит ли список хотя бы одного клиента, у которого возраст больше заданного числа.*/
        int age = 30;
        boolean isAgePresent = clients.stream()
                .anyMatch(client -> client.age() > age);
        System.out.println(String.format("3. There is client with age more than: %s - %s", age, isAgePresent));

       /* 4. Преобразовать массив в Map, у которой ключ - уникальный идентификатор, значение - имя. Поддержать порядок, в
        котором клиенты добавлены в массив.*/
        LinkedHashMap<Integer, String> idNameMap = clients.stream()
                .collect(Collectors.toMap(
                        Client::uuid,
                        Client::name,
                        (c1, c2) -> c1,
                        LinkedHashMap::new
                ));
        System.out.println("4. " + idNameMap);

        /*5. Преобразовать массив в Map, у которой ключ - возраст, значение - коллекция клиентов с таким возрастом.*/
        Map<Integer, List<Client>> ageToClient = clients.stream()
                .collect(Collectors.groupingBy(Client::age));
        System.out.println("5. " + ageToClient);

        /*6. Получить строку, содержащую телефоны всех клиентов через запятую. Предусмотреть, что у клиента телефонов может
        и не быть.*/
        String phonesStr = clients.stream()
                .map(Client::phones)
                .flatMap(Collection::stream)
                .map(phone -> phone.number)
                .collect(Collectors.joining(","));
        System.out.println("6. " + phonesStr);

        /*7. Найти самого возрастного клиента, которой пользуется стационарным телефоном*/
        clients.stream()
                .filter(client -> client.phones().stream().anyMatch(phone -> phone.type() == PhoneType.DIAL))
                .max(Comparator.comparing(Client::age))
                .ifPresent(
                        client -> System.out.println("7. " + client)
                );
    }

    public static record Client(int uuid, String name, int age, List<Phone> phones) { }

    public static record Phone(String number, PhoneType type) { }

    public static enum PhoneType {
        DIAL,
        MOBILE
    }
}
