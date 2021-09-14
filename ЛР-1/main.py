import math

# Коеффициенты
a = 0.0
b = 0.0
c = 0.0


def default_input():
    a, b, c = 0., 0., 0.
    print("Введите коеффициенты биквадратного уравнения")
    correct = False
    while not correct:
        try:
            a = float(input('A >>> '))
            correct = True
        except:
            print('Некорректный ввод. Попробуйте ещё раз.\nВ качестве разделителя целой и дробной части используйте десятичную ТОЧКУ (.)')
            continue
    correct = False
    while not correct:
        try:
            b = float(input('B >>> '))
            correct = True
        except:
            print('Некорректный ввод. Попробуйте ещё раз.\nВ качестве разделителя целой и дробной части используйте десятичную ТОЧКУ (.)')
            continue
    correct = False
    while not correct:
        try:
            c = float(input('C >>> '))
            correct = True
        except:
            print('Некорректный ввод. Попробуйте ещё раз.\nВ качестве разделителя целой и дробной части используйте десятичную ТОЧКУ (.)')
            continue
    return a, b, c


def calculate(a, b, c):
    d = b ** 2 - 4 * a * c
    if d < 0:
        return 0, 1., 2., 3., 4.  # Количество корней и 4 корня. Здесь нет корней!!!
    kd = math.sqrt(d)  # Корень из дискриминанта
    kd_plus = b * (-1) + kd
    kd_minus = b * (-1) - kd
    if a == 0:
        return 0, 22.22, 22.22, 22.22, 22.22 #Корней нет. Деление на 0.
    kd_plus /= 2 * a
    kd_minus /= 2 * a
    insert_k_one = False  # Один внутренний корень?
    if d == 0:
        insert_k_one = True
    external_k1 = 0.0
    external_k2 = 0.0
    external_k1 = math.sqrt(kd_plus) if kd_plus >= 0 else 0.0
    external_k2 = math.sqrt(kd_minus) if kd_minus >= 0 else 0.0

    if kd_plus < 0 and kd_minus < 0:
        return 0, 0.2, 0.2, 0.2, 0.2  # Корней нет!!!
    elif external_k1 > 0 and external_k2 > 0:
        return 4, external_k1, external_k2, -external_k1, -external_k2
    elif external_k1 == 0 and external_k2 == 0:
        return 1, external_k1, external_k2, 2222.55, 876.55  # Один корень ноль
    elif external_k1 > 0 and kd_minus < 0:
        return 2, external_k1, -external_k1, 222.22, 222.22
    elif kd_plus < 0 and external_k2 > 0:
        return 2, external_k2, -external_k2
    elif external_k1 > 0 and external_k2 == 0:
        return 3, external_k1, external_k2, -external_k1, 222.2  # 3 корня
    elif external_k1 == 0 and external_k2 > 0:
        return 3, external_k1, external_k2, -external_k2, 2222.2


a, b, c = default_input()
count, k1, k2, k3, k4 = calculate(a, b, c)

if count == 0:
    print('Корней нет!')
elif count == 1:
    print(k1)
elif count == 2:
    print(f"2 корня: {k1} и {k2}")
elif count == 3:
    print(f"3 корня: {k1}, {k2} и {k3}")
else:
    print(f"4 корня: {k1}, {k2}, {k3} и {k4}")
