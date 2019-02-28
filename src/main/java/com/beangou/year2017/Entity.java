package com.beangou.year2017;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/31
 * @since 1.0
 */
public class Entity {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
