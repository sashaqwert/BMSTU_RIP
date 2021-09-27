import time
from contextlib import contextmanager


class cm_timer_1:

    def __init__(self):
        self.start_time = time.time()

    def __enter__(self):
        # Должен возвращаться значимый объект
        # например, открытый файл
        return 333

    def __exit__(self, exp_type, exp_value, traceback):
        if exp_type is not None:
            print(exp_type, exp_value, traceback)
        else:
            print('Время работы участка кода = ', time.time() - self.start_time, 'секунд')


@contextmanager
def cm_timer_2():
    t_start = time.time()
    yield 333
    print('Время работы участка кода = ', time.time() - t_start, 'секунд')


if __name__ == '__main__':
    print('Первый таймер: ', end='')
    with cm_timer_1():
        time.sleep(5.5)

    print('Второй таймер: ', end='')
    with cm_timer_2():
        time.sleep(5.5)
