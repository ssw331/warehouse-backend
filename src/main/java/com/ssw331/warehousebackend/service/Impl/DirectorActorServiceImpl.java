package com.ssw331.warehousebackend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorDirector;
import com.ssw331.warehousebackend.mapper.StaticActorActorMapper;
import com.ssw331.warehousebackend.mapper.StaticDirectorActorMapper;
import com.ssw331.warehousebackend.mapper.StaticDirectorDirectorMapper;
import com.ssw331.warehousebackend.service.DirectorActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DirectorActorServiceImpl implements DirectorActorService {
        @Autowired
        private StaticDirectorActorMapper staticDirectorActorMapper;
        @Autowired
        private StaticDirectorDirectorMapper staticDirectorDirectorMapper;
        @Autowired
        private StaticActorActorMapper staticActorActorMapper;

        @Override
        public List<String> getActorNamesByDirectorName(String directorName) {
            QueryWrapper<StaticDirectorActor> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("director_name", directorName);
            List<StaticDirectorActor> staticDirectorActors = staticDirectorActorMapper.selectList(queryWrapper);

            List<String> actorNames = new ArrayList<>();
            for (StaticDirectorActor staticDirectorActor : staticDirectorActors) {
                actorNames.add(staticDirectorActor.getActorName());
            }
            return actorNames;
        }

        @Override
        public List<String> getDirectorNamesByDirectorName(String directorName) {
            QueryWrapper<StaticDirectorDirector> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("director_name", directorName);
            List<StaticDirectorDirector> staticDirectorDirectors = staticDirectorDirectorMapper.selectList(queryWrapper);

            List<String> directorNames = new ArrayList<>();
            for (StaticDirectorDirector staticDirectorDirector : staticDirectorDirectors) {
                directorNames.add(staticDirectorDirector.getDirectorName2());
            }
            return directorNames;
        }

        @Override
        public List<String> getActorNamesByActorName(String actorName) {
            QueryWrapper<StaticActorActor> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("actor_name1", actorName);
            List<StaticActorActor> staticActorActors = staticActorActorMapper.selectList(queryWrapper);
            List<String> actorNames = new ArrayList<>();
            for (StaticActorActor staticActorActor : staticActorActors) {
                actorNames.add(staticActorActor.getActorName2());
            }
            return actorNames;
        }

        @Override
        public List<String> getDirectorNamesByActorName(String actorName) {
            QueryWrapper<StaticDirectorActor> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("actor_name", actorName);
            List<StaticDirectorActor> staticDirectorActors = staticDirectorActorMapper.selectList(queryWrapper);

            List<String> directorNames = new ArrayList<>();
            for (StaticDirectorActor staticDirectorActor : staticDirectorActors) {
                directorNames.add(staticDirectorActor.getDirectorName());
            }
            return directorNames;
        }
    }

