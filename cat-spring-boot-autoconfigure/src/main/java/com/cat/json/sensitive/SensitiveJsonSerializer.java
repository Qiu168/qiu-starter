package com.cat.json.sensitive;

import cn.hutool.core.util.ObjectUtil;
import com.cat.utils.SpringUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.beans.BeansException;
import java.io.IOException;
import java.util.Objects;

/**
 * jackson的脱敏工具
 *
 * @author qiu
 */
public class SensitiveJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SensitiveJsonSerializer.class);
    private Desensitize strategy;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        try {
            SensitiveService sensitiveService = SpringUtil.getBean(SensitiveService.class);
            if (ObjectUtil.isNotNull(sensitiveService) && sensitiveService.isSensitive()) {
                gen.writeString(strategy.desensitizer().apply(value));
            } else {
                gen.writeString(value);
            }
        } catch (BeansException e) {
            log.error("脱敏实现不存在, 采用默认处理 => {}", e.getMessage());
            gen.writeString(value);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        Sensitive annotation = property.getAnnotation(Sensitive.class);
        if (Objects.nonNull(annotation) && Objects.equals(String.class, property.getType().getRawClass())) {
            String strategyStr = annotation.strategy();
            Class<? extends Desensitize> Class = annotation.strategyClass();
            if (!Class.isEnum()) {
                return prov.findValueSerializer(property.getType(), property);
            }
            Class<? extends Enum> strategyClass = (Class<? extends Enum>) Class;
            Enum instance = Enum.valueOf(strategyClass, strategyStr);
            this.strategy = (Desensitize) instance;
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }
}
