package com.zytcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zytcode.entity.GeoCode;
import com.zytcode.mapper.GeoCodeMapper;
import com.zytcode.service.GeoCodeService;
import org.springframework.stereotype.Service;

@Service
public class GeoCodeServiceImpl extends ServiceImpl<GeoCodeMapper, GeoCode> implements GeoCodeService {
}
