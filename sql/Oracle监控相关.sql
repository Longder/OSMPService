--查询总会话数，活动会话数
select status,count(*) as "SESSIONS" from v$session group by status  having status in ('INACTIVE','ACTIVE');
--查询PGA信息（目标尺寸，当前尺寸，PGA使用率）
select a.value as pgaTarget,b.value as pgaUsed,round(b.value/a.value,2) as pgaUsage from v$pgastat a,v$pgastat b where a.name='total PGA allocated' and b.name='total PGA inuse';
--查询PGA内存排序率
select round((100*b.value)/decode((a.value+b.value),0,1,(a.value+b.value)),2) as Pct_Memory_Sorts from v$sysstat a,v$sysstat b where a.name = 'sorts (disk)' and b.name = 'sorts (memory)';
--查询PGA专用连接数
select count(*) as dedicated_num from v$session where USERNAME not in ('DBSNMP','SYSMAN','SYS') and USERNAME is not null and SERVER = 'DEDICATED';
--查询PGA共享连接数
select value as shared_num from v$parameter where NAME ='shared_servers';


--sga基本信息
select * from v$sgainfo;
--各种共享池信息
select pool ,sum(bytes) bytes from v$sgastat group by pool;
--库高速缓存
select sum(sharable_mem) from v$db_object_cache;
--SQL命中率
select sum(pinhits)/sum(pins) as pinhitratio from v$librarycache;
--数据字典高速缓存
select sum(sharable_mem) from v$sqlarea;
--数据命中率
SELECT 1 - (PHYSICAL_READS / (DB_BLOCK_GETS + CONSISTENT_GETS)) "Hit Ratio" FROM V$BUFFER_POOL_STATISTICS WHERE NAME='DEFAULT';
