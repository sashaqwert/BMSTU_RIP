import freegames
from lab_python_oop.rectangle import Rectangle
from lab_python_oop.circle import Circle
from lab_python_oop.square import Square


def main():
    r = Rectangle("синего", 3, 6)
    c = Circle("зеленого", 5)
    s = Square("красного", 10)
    print(r)
    print(c)
    print(s)

    print()
    print('Для закрытия окна введите Enter в консоль')
    freegames.utils.line(0, 0, 1000, 1000) # Окно с линией
    input()


if __name__ == '__main__':
    main()

# Пакет freegames
