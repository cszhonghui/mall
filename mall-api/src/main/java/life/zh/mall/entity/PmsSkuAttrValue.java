package life.zh.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * sku平台属性值关联表
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsSkuAttrValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性id（冗余)
     */
    private Long attrId;

    /**
     * 属性值id
     */
    private Long valueId;

    /**
     * skuid
     */
    private Long skuId;


}
