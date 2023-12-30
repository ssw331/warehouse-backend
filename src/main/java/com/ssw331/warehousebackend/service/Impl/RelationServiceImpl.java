package com.ssw331.warehousebackend.service.Impl;

import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorDirector;
import com.ssw331.warehousebackend.mapper.ActorActorMapper;
import com.ssw331.warehousebackend.mapper.DirectorActorMapper;
import com.ssw331.warehousebackend.mapper.DirectorDirectorMapper;
import com.ssw331.warehousebackend.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelationServiceImpl implements RelationService {

    @Autowired
    private DirectorActorMapper directorActorMapper;
    private ActorActorMapper actorActorMapper;
    private DirectorDirectorMapper directorDirectorMapper;

    public RelationServiceImpl(ActorActorMapper actorActorMapper, DirectorDirectorMapper directorDirectorMapper) {
        this.actorActorMapper = actorActorMapper;
        this.directorDirectorMapper = directorDirectorMapper;
    }


    @Override
    public List<StaticDirectorActor> getTop20DirectorActorCollaborations() {
        return directorActorMapper.findTop20DirectorActorCollaborations();
    }

    @Override
    public List<StaticActorActor> getTop20ActorActorCollaborations() {
        return actorActorMapper.findTop20ActorActorCollaborations();
    }

    @Override
    public List<StaticDirectorDirector> getTop20DirectorDirectorCollaborations() {
        return directorDirectorMapper.findTop20DirectorDirectorCollaborations();
    }
}
