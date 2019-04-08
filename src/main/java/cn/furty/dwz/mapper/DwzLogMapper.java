package cn.furty.dwz.mapper;

import cn.furty.dwz.pojo.DwzLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DwzLogMapper {
    @Insert("insert into dwz_log values(0, #{log.dwzId}, default)")
    public int addLog(@Param("log") DwzLog log);
}
