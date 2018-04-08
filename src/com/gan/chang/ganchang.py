import math
def print_hourglass(total_number, mark_char):
        n = int(math.sqrt((total_number + 1)/2.0))
        print '\n'.join([ ' ' * x + '*' * y for (x, y) in zip(range(0, n) + range(n-2, -1, -1), range(2*n -1, 1, -2) + range(1, 2*n, 2))])
        print total_number - 2 * n * n + 1


print_hourglass(19, '*')
