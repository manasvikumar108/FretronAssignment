import matplotlib.pyplot as plt

flight_1 = [(1, 1), (2, 2), (3, 3)]
flight_2 = [(1, 1), (2, 4), (3, 2)]
flight_3 = [(1, 1), (4, 2), (3, 4)]

def extract_coords(flight):
    x, y = zip(*flight)
    return x, y

def plot_flight_path(flight, color, label):
    x, y = extract_coords(flight)
    plt.plot(x, y, marker='o', color=color, label=label)

plot_flight_path(flight_1, 'blue', 'Flight 1')
plot_flight_path(flight_2, 'green', 'Flight 2')
plot_flight_path(flight_3, 'red', 'Flight 3')

plt.xlim(1, 5)
plt.ylim(1, 5)

plt.xlabel('X Coordinate')
plt.ylabel('Y Coordinate')
plt.title('Flight Paths with Specified Gaps')
plt.legend()
plt.grid(True)

plt.show()