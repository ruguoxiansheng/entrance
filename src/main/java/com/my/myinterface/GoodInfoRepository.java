package com.my.myinterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.GoodInfoEntity;

public interface GoodInfoRepository  extends JpaRepository<GoodInfoEntity,Long>
{
}
