package cn.json.branch.anno;

import java.math.BigDecimal;

/**
 * 枚举出json解析过程中常用的一些类型
 * Created by syq on 2016/7/26.
 */
public enum  Types {

    JSON_OBJECT{
        @Override
        public Class getTypeClass() {
            return Object.class;
        }
    },
    JSON_OBJECT_ARRAY{
        @Override
        public Class getTypeClass() {
            return Object.class;
        }
    },
    INT{
        @Override
        public Class getTypeClass() {
            return Integer.class;
        }
    },
    FLOAT{
        @Override
        public Class getTypeClass() {
            return Float.class;
        }
    },
    DOUBLE{
        @Override
        public Class getTypeClass() {
            return Double.class;
        }
    },
    LONG{
        @Override
        public Class getTypeClass() {
            return Long.class;
        }
    },
    DECIMAL{
        @Override
        public Class getTypeClass() {
            return BigDecimal.class;
        }
    },
    STRING{
        @Override
        public Class getTypeClass() {
            return String.class;
        }
    },
    INT_ARRAY{
        @Override
        public Class getTypeClass() {
            return Integer.class;
        }
    },
    FLOAT_ARRAY{
        @Override
        public Class getTypeClass() {
            return Float.class;
        }
    },
    DOUBLE_ARRAY{
        @Override
        public Class getTypeClass() {
            return Double.class;
        }
    },
    LONG_ARRAY{
        @Override
        public Class getTypeClass() {
            return Long.class;
        }
    },
    DECIMAL_ARRAY{
        @Override
        public Class getTypeClass() {
            return BigDecimal.class;
        }
    },
    STRING_ARRAY{
        @Override
        public Class getTypeClass() {
            return String.class;
        }
    };


    public abstract Class getTypeClass();
}
