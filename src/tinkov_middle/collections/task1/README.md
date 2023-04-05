## Задача №1

Написать метод, который на вход получает массив (или список) строк в формате “имя_игрока количество_очков”. Требуется 
вывести на экран имя победителя. Победителем считается тот, кто набрал больше всех очков и сделал это раньше остальных 
(у нескольких игроков может быть одинаковое количество очков). Порядок начисления очков определяется порядком 
следования элементов в массиве.

Пример:

* на вход: «Ivan 5», «Petr 3», «Alex 10», «Petr 8», «Ivan 6», «Alex 5», «Ivan 1», «Petr 5», «Alex 1»
* победитель: Petr
* объяснение: у Alex и Petr одинаково наибольшее количество очков (16), но т.к. Petr набрал их раньше, чем Alex, 
* поэтому победителем является Petr


Реализовать метод showWinner:

```java
public static void showWinner(List<String> competitors){
// implement
}
```