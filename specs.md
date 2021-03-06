МИНИСТЕРСТВО ОБРАЗОВАНИЯ И НАУКИ
РОССИЙСКОЙ ФЕДЕРАЦИИ
САНКТ-ПЕТЕРБУРГСКИЙ НАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ ИНФОРМАЦИОННЫХ ТЕХНОЛОГИЙ, МЕХАНИКИ И ОПТИКИ
Факультет программной инженерии и компьютерных технологий
Кафедра информатики и прикладной математики







Отчёт по первому этапу курсовой работы
по дисциплине
&quot;Программирование интернет-приложений&quot;





Выполнили: Студенты группы Р3219
Ломаев Никита
Южаков Егор
Лавриненко Владислав
(вариант 500)
Преподаватель: тьютор кафедры ВТ
Харитонова Анастасия Евгеньевна





Санкт-Петербург, 2017

# Техническое задание

На первом этапе необходимо по заданному шаблону написать техническое задание на разрабатываемую систему и утвердить его у преподавателя. Техническое задание обязательно должно включать в себя следующие элементы:

1. Перечисление функциональных и нефункциональных требований к разрабатываемой системе.
2. Описание и UML-диаграммы прецедентов использования системы.
3. Описание и блок-схема архитектуры разрабатываемой системы.
4. Прототипы всех интерфейсов системы.

Помимо этого, техническое задание может включать в себя дополнительные элементы, номенклатура которых зависит от конкретного варианта задания на курсовую работу.

Формальным отчётом по первому этапу курсовой работы является техническое задание.

# Описание системы

_WeKnow_ ­– сайт, содержащий различные статьи (т.н. гайды), призванные помочь и предоставить новую информацию игрокам в ролевую компьютерную игру The Elder Scrolls V: Skyrim. В основе сайта находится каталог вышеупомянутых статей, в котором они рассортированы по различным категориям, которые пишут и публикуют редакторы и администраторы сайта. Каждая статья может быть оценена пользователями и имеет секцию комментариев, где пользователь имеет возможность оставить своё мнение о прочитанном. Также в каждой статье есть ссылки на конкретные упомянутые в ней объекты (персонажей, квесты, предметы и т.д.), связанные с базой данных. Зарегистрированные пользователи могут подписаться на еженедельный дайджест свежих статей, который будет отправляться им на электронную почту.





# Функциональные и нефункциональные требования к разрабатываемой системе

| **№** | **Требования** | **Приоритет** | **Стабильность** |
| --- | --- | --- | --- |
| Функциональные требования |
| Требования пользователей |
| 1 | Регистрация по электронной почте | MUST have | High |
| 2 | Еженедельный дайджест с оповещением по электронной почте | MUST have | High |
| 3 | Система комментариев под статьями | SHOULD have | High |
| 4 | Поиск по статьям | SHOULD have | High |
| 5 | Блок свежих статей на главной странице сайта | MUST have | High |
| 6 | Авторизация на сайте | MUST have | High |
| 7 | Каталог статей с сортировкой по тегам и времени добавления | SHOULD have | High |
| 8 | Система оценки статей | MUST have | High |
| Требования редакторов сайта |
| 1 | Добавление статей на сайт | MUST have | High |
| 2 | Удаление своих статей | MUST have | High |
| 3 | Редактирование своих статей | MUST have | High |
| 4 | Добавление тегов к своим статьям | MUST have | High |
| Требования администраторов сайта |
| 1 | Возможность блокирования пользователей | MUST have | High |
| 2 | Удаление всех статей | MUST have | High |
| 3 | Добавление тегов ко всем статьям | MUST have | High |
| 4 | Возможность всех редактирования статей | MUST have | High |
| 5 | Возможность удаления комментариев других пользователей | MUST have | High |
| Нефункциональные требования |
| 1 | Возможность регистрации только на один адрес почты | MUST have | High |
| 2 | Уровень back-end должен быть основан на Spring | MUST have | High |
| 3 | Уровень front-end должен быть построен на Vue.js с использованием обычных полей ввода HTML | MUST have | High |
| 4 | Взаимодействие между уровнями back-end и front-end должно быть организовано посредством REST API | MUST have | High |
| 5 | Все веб-интерфейсы системы должны быть адаптированы для отображения в 3 режимах: десктопный, мобильный, планшетный | MUST have | High |
| 6 | Для доступа к БД необходимо использовать Spring Data | MUST have | High |
| 7 | Ролевое разграничение доступа к внутренним разделам системы должно быть организовано с помощью технологии Spring Security | MUST have | High  |
| 8 | Cистема оповещения пользователей о важных событиях посредством сообщений электронной почты должна быть реализована с помощью JavaMail API | MUST have | High  |
| 9 | Стабильная работа в популярных браузерах (Chrome, FF, Opera, Safari, Edge, IE) | MUST have | High  |