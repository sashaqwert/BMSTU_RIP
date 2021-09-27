import json
import lab_python_fp.print_result as print_result
import lab_python_fp.cm_timer as cm_timer
import lab_python_fp.unique as unique
import lab_python_fp.gen_random as gen_random

# Сделаем другие необходимые импорты

path = "A:\\sasha\\YandexDisk\\МГТУ\\7-й семестр\\РИП\\ЛР\\3\\data_light.json"

# Необходимо в переменную path сохранить путь к файлу, который был передан при запуске сценария

with open(path, encoding='utf-8') as f:
    data = list(json.load(f))


# Далее необходимо реализовать все функции по заданию, заменив `raise NotImplemented`
# Предполагается, что функции f1, f2, f3 будут реализованы в одну строку
# В реализации функции f4 может быть до 3 строк

@print_result.print_result
def f1(arg):
    professions = list()
    for element in arg:
        professions.append(dict(element).get('job-name'))
    u = unique.Unique(professions, ignore_case=True)
    return sorted(u)


@print_result.print_result
def f2(arg: list):
    def f_func(arg_: str):
        if arg_.startswith('программист') or arg_.startswith('Программист'):
            return True
        else:
            return False

    filtered = filter(f_func, arg)
    return list(filtered)


@print_result.print_result
def f3(arg :list):
    def mod_f(arg_m : str):
        arg_m += ' с опытом Python'
        return arg_m

    return list(map(mod_f, arg))


@print_result.print_result
def f4(arg :list):
    l = len(arg)
    r_m = gen_random.gen_random(l, 100000, 200000)
    zp = list()
    for _ in arg:
        zp.append('зарплата ' + str(int(next(r_m))) + ' руб.')
    ZP = list(zip(arg, zp))
    return ZP


if __name__ == '__main__':
    with cm_timer.cm_timer_1():
        f4(f3(f2(f1(data))))
