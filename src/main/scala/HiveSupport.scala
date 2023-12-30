import org.apache.spark.sql.SparkSession


object HiveSupport {
  def main(args: Array[String]): Unit = {
    //val warehouseLocation = "D:\\workspaces\\idea\\hadoop"

    val spark =
      SparkSession.builder()
        .appName("HiveSupport")
        .master("spark://cc3.accr.cc:7077")
        //拷贝hdfs-site.xml不用设置，如果使用本地hive，可通过该参数设置metastore_db的位置
        //.config("spark.sql.warehouse.dir", warehouseLocation)
        .enableHiveSupport() //开启支持hive
        .getOrCreate()

    //spark.sparkContext.setLogLevel("WARN") //设置日志输出级别
    import spark.sql

    sql("show databases")
    sql("use default")
    sql("select * from product_info").show()

    Thread.sleep(150 * 1000)
    spark.stop()
  }
}