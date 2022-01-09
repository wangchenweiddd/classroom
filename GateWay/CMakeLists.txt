cmake_minimum_required(VERSION 3.6)
project(CGIText)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata.keystream
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata.keystream.len
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata.len
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata.values.at
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata_i
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/_metadata_/metadata_i.len
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c/storage.xml
        .idea/dataSources/1b43853f-2d60-4fa2-ba0e-a9d1767b216c.xml
        .idea/inspectionProfiles/profiles_settings.xml
        .idea/CGIText.iml
        .idea/dataSources.local.xml
        .idea/dataSources.xml
        .idea/misc.xml
        .idea/modules.xml
        .idea/workspace.xml
        DataBase/__init__.py
        DataBase/Config.py
        DataBase/Connect.py
        DataBase/DAL.py
        DataBase/Model.py
        Helper/__init__.py
        Helper/JsonHelper.py
        Helper/LogHelper.py
        PostConduct/__init__.py
        PostConduct/PostIni.py
        logging.txt
        main.py)

add_executable(CGIText ${SOURCE_FILES})