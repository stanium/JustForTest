LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional

LOCAL_PACKAGE_NAME :=JustForTest

LOCAL_CERTIFICATE :=platform

LOCAL_PROGUARD_ENABLED :=disabled

LOCAL_JAVA_LIBRARIES :=com.mediatek.effect

#LOCAL_JNI_SHARED_LIBRARIES:=

LOCAL_DEX_PREOPT :=false

LOCAL_SRC_FILES := $(call all-java-files-under, src)
LOCAL_MANIFEST_FILE :=/src/main/AndroidManifest.xml
LOCAL_RESOURCE_DIR :=$(LOCAL_PATH)/src/main/res/

include $(BUILD_PACKAGE)



include $(call all-makefiles-under,$(LOCAL_PATH))
#include $(call all-subdir-makefiles)
