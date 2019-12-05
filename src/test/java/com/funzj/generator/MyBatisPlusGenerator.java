package com.funzj.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * <p>
 *     代码生成器请勿轻易操作
 * </p>
 * @author ZJ.Fun
 */
public class MyBatisPlusGenerator {

    private final static String OUT_PUT_PATH;

    // 在这里配置生成的代码的存放路径,建议不要放在项目路径下,以免代码覆盖
    static {
        OUT_PUT_PATH = "F:/workspace/IDEA/codeWrite/src/main/java/com/funzj";
    }

    @Test
    public void generator() {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //生成存放地址
        gc.setOutputDir(OUT_PUT_PATH);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("D.Yang");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setTypeConvert(new MySqlTypeConvert() {

            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });

        // 设置数据库类型
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("******");
        dsc.setUrl("jdbc:mysql://******/cloudDB01?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[] { "" });
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //生成指定表
        //strategy.setInclude(new String[]{"dept"});
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com");
        pc.setModuleName("funzj");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        /*
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);
        */

        // 执行生成
        mpg.execute();
        // 打印注入设置
        //System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}
