package com.zxj.config;

/**
 * 支付宝相关并配置信息
 *
 * notify_url 和 return_url 需要外网可以访问，建议natapp 内网穿透
 * @author zxj
 * @date 2021-03-04 11:37
 */
public class AlipayConfig {
    //这里用natapp内外网穿透
    //public static final String natUrl = "http://gca8w8.natappfree.cc";
    public static final String natUrl = "http://localhost:8082";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102700769715";//在后台获取（必须配置）

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzGTLGkwHQz2L0h7jQ4sUq2DuZ3iYpvHPdoFlDRF6l4ukf6XQpS3UhvdJSWyDqzEYNbYiQsoPlaxSiUSu1GqdmNALYQWrfGDuaAHYjzipAH4XJDmLiW/Q4WmTS1l3jOJMbP+sZFSswX3HIhtdmh+lOkVCs2q9CGzmjufHtD0Uea0LgJZaTHN8T8YWJhqn3+8Y8WrtGlUl7JmiU50JTNa4/5l2Uao0vfsSLFEuhmNbF9wLFj3QfghAQXixhPD3HFy9Lm+VhiDBHs3iQbc9F9UR/TH3zHzEd1OJGiGGpNXNpKinJM4L9BnEDggDbOZDPlAw/Mq3MDvn3/0ljeIhnSKbxAgMBAAECggEAD88knUSyv1TfHkiwtredweduc2mZosuAyspxtq9dT3VVMLzxxQdlIoJYA28J29AGSv8lM+ieHe0y2BUkL4tXxXzH14EGxwSjljd+NjDnp9tgetvrPKHzT9oi1j2X8gu3aIte3ErzEgUKzTGh5+oNXSMUpP10xPgUQXCTe2KCrmmROzrIE7Ya7RuvTcdSjSzQvSvDFZWxU1jlQcwnLymDimRUX8U/ai3oBVGYZftvNN7UajNvG8l2wj9dwZ9mgN5BKq1zXcbq5zvZl4MmOLcLJQH6Y1/dya/gCGdb9jxKOwaoXlxOTkpEeVs68MUzxo4W8ZzCgsi7yo6Hk4RT62rOcQKBgQD358A1o0R0psOze+Who2ijrHSBSDbEDE4yRNRbPaWer4INy0UPhmSQXBytN/2B8a20YgSUbA/SKHinSZKXzJu6ffBxLikoEdUuRfogbMkeugfX/eBKYX2jYxXZOTBCJ6Ew83KjLZFatVb12j7oydpu9og3KeWBiwbAupvNuNIAhQKBgQC48kniZcUX7jxzJ9fNaI+ClyJxVoeiue5bGaARjXSuhdI+syt07Iddl/7BhfrdKEaYHKgnu+rZgo2XGog7c3qdKiFAdaYSP79dkZ8EkjlinYYrJFz8WcLskRONGh2Ctex6Z7ZQDWKk8ojYSmMzVu8jP71xNejsy+wX0GJDehSufQKBgAUzgI3fig0kfpCiddPpWMWuVZdsy3FbjLxzQz1S0sm8hu8BJ8bGnA+HTza3KQNz7aAOOmheyAoxvS5NVd0HdvD3uXa2cDid/yoEX9YUUjfp0UZP1kfZOciWyJuRHpkUucYMJYiU6SrNCTEJTi6WJZYUaBE4OM95+j9K6v/q88T9AoGAOdNvrHzbehcACZVckRnvPQqaN0uxzvxJfWxusu5CnEq1KOuGW+GUlXvvqHyGql1sbSUQopPL40RBlwwxqjz6Cmfgy7G9QhlycQQV7yz1ClNsXtLYzAIYwzS9IzIWJgdRsBf7Vd5JiH9YsB/aEnRNAv1r8xjDAj7kS7HY93YVP1UCgYAIr/qj2rbV7Q/WBuh/ToQz52RF2Nlu07X7bEX5HxirixMzDD6UCDHyzR45/k85PXPAGLGQvIgTNWzIZTBERT3kbdpVF2KMHNLHqp3y4qMV/MF8O/wLKqH8ft+CoFkGqFGr9QDBEHIQ+KvX/FvoSXkffZL2pXCDD6JSTJ8Vt9ejmw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.html 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiPTrGwVEKO8SBqMaOfHIdLJ7zXLagqgEBOUVh/c9OhrtprfggM6fGOemGFRNBC5c7a7Ykh3lrvwuEkNkdG69pjUEQm1VV5XU5n0+xX1luO607YtpzPhpl468hSftHF26iUl+mjF8PbSUOJBP5bTx8OfZ6yitWuxpqSkvOCwAZBpvQrOmq0AWvRXA0EbaJgtevu7qHX2qVHpHIOT31QbGe2pCOycIPo8r6EEb8vq/RM/KwODYUdEpTae9cl/2JU31OKkVls08nMRYagobrFBbY1olsn6E/M7U2b/8CWrXaVXJ3lxV66t7aN3vcEw/Ew+ihbu897tkvJhPzJ/9itLC4QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = natUrl + "/alipay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = natUrl + "/alipay/alipayReturnNotice";
    //    public static String return_url = "http://login.calidray.com/?#/sign";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do

}
