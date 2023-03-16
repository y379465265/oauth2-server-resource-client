package com.izejin.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述： 对象转换、拷贝工具类
 * 字段的类型和名称一致才会转换
 * <p>
 * 创建时间：2019/5/30 11:48
 * 修改时间：
 *
 */
public final class BeanUtil {
    private BeanUtil() {}

    private enum ModelMapperHolder {
        /**
         * 单例
         */
        INSTANCE;

        private ModelMapper modelMapper;

        ModelMapperHolder() {
            this.modelMapper = new ModelMapper();
            this.modelMapper.getConfiguration()
                    .setFullTypeMatchingRequired(true)
                    .setMatchingStrategy(MatchingStrategies.STRICT);
        }

        public ModelMapper getModelMapper() {
            return modelMapper;
        }
    }

    /**
     * 对象列表转换
     * 字段的类型和名称一致才会转换
     * @param list 源对象列表
     * @param clazz 目标对象类型
     * @param <T> 目标类
     * @return 目标对象列表
     */
    public static <T> List<T> convert(Collection<?> list, Class<T> clazz) {
        return list.isEmpty() ? new ArrayList<>() : list.stream().map(e -> convert(e, clazz)).collect(Collectors.toList());
    }

    /**
     * 对象转换
     * 字段的类型和名称一致才会转换
     * @param source 源对象
     * @param clazz 目标对象类型
     * @param <T> 目标类
     * @return 目标对象
     */
    public static <T> T convert(Object source, Class<T> clazz) {
        return ModelMapperHolder.INSTANCE.getModelMapper().map(source, clazz);
    }


    /**
     * 对象内容拷贝
     * @param source 源对象
     * @param destination 目标对象
     */
    public static void copy(Object source, Object destination) {
        ModelMapperHolder.INSTANCE.getModelMapper().map(source, destination);
    }
}
