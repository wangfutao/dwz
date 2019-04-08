package cn.furty.dwz.mapper;

import cn.furty.dwz.pojo.Dwz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DwzMapper {
    @Select("select * from dwz")
    public List<Dwz> getAllDwz();

    @Select("select id, dwz, ywz from dwz where dwz=#{url} limit 1")
    public Dwz getDwz(@Param("url") String url);

    @Select("select count(*) from dwz where dwz = #{dwz}")
    public int getCount(@Param("dwz") String dwz);

    @Insert("insert into dwz values(0, #{dwz.dwz}, #{dwz.ywz}, default)")
    public int addDwz(@Param("dwz") Dwz dwz);
}
