public class Main {
    static class Animal {
        public void run(int distance) {
            System.out.println("Animal ran " + distance + " m.");
        }

        public void swim(int distance) {
            System.out.println("Animal swam " + distance + " m.");
        }
    }

    static class Cat extends Animal {
        private static int catCount = 0;
        private boolean satiety;

        public Cat() {
            catCount++;
            this.satiety = false;
        }

        @Override
        public void run(int distance) {
            if (distance <= 200) {
                System.out.println("Cat ran " + distance + " m.");
            } else {
                System.out.println("Cat can't run more than 200 m.");
            }
        }

        @Override
        public void swim(int distance) {
            System.out.println("Cat can't swim.");
        }

        public void eat(Bowl bowl, int amount) {
            if (amount > bowl.getFood()) {
                System.out.println("Not enough food in the bowl.");
            } else {
                bowl.decreaseFood(amount);
                this.satiety = true;
                System.out.println("Cat ate " + amount + " units of food.");
            }
        }

        public boolean isSatiety() {
            return satiety;
        }

        public static int getCatCount() {
            return catCount;
        }
    }

    static class Dog extends Animal {
        private static int dogCount = 0;

        public Dog() {
            dogCount++;
        }

        @Override
        public void run(int distance) {
            if (distance <= 500) {
                System.out.println("Dog ran " + distance + " m.");
            } else {
                System.out.println("Dog can't run more than 500 m.");
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= 10) {
                System.out.println("Dog swam " + distance + " m.");
            } else {
                System.out.println("Dog can't swim more than 10 m.");
            }
        }

        public static int getDogCount() {
            return dogCount;
        }
    }

    static class Bowl {
        private int food;

        public Bowl(int food) {
            this.food = food;
        }

        public int getFood() {
            return food;
        }

        public void decreaseFood(int amount) {
            if (food >= amount) {
                food -= amount;
            } else {
                System.out.println("Not enough food in the bowl.");
            }
        }


        public void addFood(int amount) {
            food += amount;
        }
    }

    public static class MainTwo {
        public static void main(String[] args) {
            Cat[] cats = {new Cat(), new Cat(), new Cat()};
            Dog dog = new Dog();

            Bowl bowl = new Bowl(20);

            for (Cat cat : cats) {
                cat.eat(bowl, 10);
                System.out.println("Cat satiety: " + cat.isSatiety());
            }

            System.out.println("Remaining food in bowl: " + bowl.getFood());

            dog.run(150);
            dog.swim(8);

            System.out.println("Total cats created: " + Cat.getCatCount());
            System.out.println("Total dogs created: " + Dog.getDogCount());
        }
    }
}
