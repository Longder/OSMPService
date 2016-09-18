package com.microdata.osmpservice.entity.model.oracle;

/**
 * Oracle SGA信息
 * Created by Longder on 2016/9/18.
 */
public class SGAInfo {
    /**
     * 目标尺寸（带单位）
     */
    private String targetSize;
    /**
     * 当前已用尺寸（带单位）
     */
    private String usedSize;
    /**
     * 固定尺寸
     */
    private String fixedSize;
    /**
     * 重做日志缓存（带单位）
     */
    private String redoBuffers;
    /**
     * 共享池（带单位）
     */
    private String sharedPoolSize;
    /**
     * 保留缓存区（带单位）
     */
    private String keepBufferCache;
    /**
     * 循环缓存区（带单位）
     */
    private String recycleBufferCache;
    /**
     * 库高速缓存（带单位）
     */
    private String libraryCache;
    /**
     * SQL命中率
     */
    private Double sqlHitRate;
    /**
     * 数据字典告诉缓存（带单位）
     */
    private String dictionaryCache;
    /**
     * 缓冲区高速缓存（带单位）
     */
    private String bufferCacheSize;
    /**
     * 缓冲区数据命中率
     */
    private Double bufferCacheHitRate;
    /**
     * JAVA池（带单位）
     */
    private String javaPoolSize;
    /**
     * 大型共享池（带单位）
     */
    private String largePoolSize;

    public String getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(String targetSize) {
        this.targetSize = targetSize;
    }

    public String getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(String usedSize) {
        this.usedSize = usedSize;
    }

    public String getFixedSize() {
        return fixedSize;
    }

    public void setFixedSize(String fixedSize) {
        this.fixedSize = fixedSize;
    }

    public String getRedoBuffers() {
        return redoBuffers;
    }

    public void setRedoBuffers(String redoBuffers) {
        this.redoBuffers = redoBuffers;
    }

    public String getSharedPoolSize() {
        return sharedPoolSize;
    }

    public void setSharedPoolSize(String sharedPoolSize) {
        this.sharedPoolSize = sharedPoolSize;
    }

    public String getKeepBufferCache() {
        return keepBufferCache;
    }

    public void setKeepBufferCache(String keepBufferCache) {
        this.keepBufferCache = keepBufferCache;
    }

    public String getRecycleBufferCache() {
        return recycleBufferCache;
    }

    public void setRecycleBufferCache(String recycleBufferCache) {
        this.recycleBufferCache = recycleBufferCache;
    }

    public String getLibraryCache() {
        return libraryCache;
    }

    public void setLibraryCache(String libraryCache) {
        this.libraryCache = libraryCache;
    }

    public Double getSqlHitRate() {
        return sqlHitRate;
    }

    public void setSqlHitRate(Double sqlHitRate) {
        this.sqlHitRate = sqlHitRate;
    }

    public String getDictionaryCache() {
        return dictionaryCache;
    }

    public void setDictionaryCache(String dictionaryCache) {
        this.dictionaryCache = dictionaryCache;
    }

    public String getBufferCacheSize() {
        return bufferCacheSize;
    }

    public void setBufferCacheSize(String bufferCacheSize) {
        this.bufferCacheSize = bufferCacheSize;
    }

    public Double getBufferCacheHitRate() {
        return bufferCacheHitRate;
    }

    public void setBufferCacheHitRate(Double bufferCacheHitRate) {
        this.bufferCacheHitRate = bufferCacheHitRate;
    }

    public String getJavaPoolSize() {
        return javaPoolSize;
    }

    public void setJavaPoolSize(String javaPoolSize) {
        this.javaPoolSize = javaPoolSize;
    }

    public String getLargePoolSize() {
        return largePoolSize;
    }

    public void setLargePoolSize(String largePoolSize) {
        this.largePoolSize = largePoolSize;
    }
}
