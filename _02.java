/**
 * 02 单例模式
 */
public class _02 {
//    懒汉式-线程不安全
//    public class Singleton {
//
//        private static Singleton uniqueInstance;
//
//        private Singleton() {
//        }
//
//        public static Singleton getUniqueInstance() {
//            if (uniqueInstance == null) {
//                uniqueInstance = new Singleton();
//            }
//            return uniqueInstance;
//        }
//    }

//    双重校验锁-线程安全
//    public class Singleton {
//
//        private volatile static Singleton uniqueInstance;
//
//        private Singleton() {
//        }
//
//        public static Singleton getUniqueInstance() {
//            if (uniqueInstance == null) {
//                synchronized (Singleton.class) {
//                    if (uniqueInstance == null) {
//                        uniqueInstance = new Singleton();
//                    }
//                }
//            }
//            return uniqueInstance;
//        }
//    }

//    静态内部类实现
//    public class Singleton {
//
//        private Singleton() {
//        }
//
//        private static class SingletonHolder {
//            private static final Singleton INSTANCE = new Singleton();
//        }
//
//        public static Singleton getUniqueInstance() {
//            return SingletonHolder.INSTANCE;
//        }
//    }
}
