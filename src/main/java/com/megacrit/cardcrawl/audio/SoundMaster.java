//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.megacrit.cardcrawl.audio;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoundMaster {
    private static final Logger logger = LogManager.getLogger(SoundMaster.class.getName());
    private HashMap<String, Sfx> map = new HashMap();
    private ArrayList<SoundInfo> fadeOutList = new ArrayList();
    private static final String SFX_DIR = "audio/sound/";

    public SoundMaster() {
        long startTime = System.currentTimeMillis();
        Settings.SOUND_VOLUME = Settings.soundPref.getFloat("Sound Volume", 0.5F);
        this.map.put("AMBIANCE_BOTTOM", this.load("SOTE_Level1_Ambience_v6.ogg"));
        this.map.put("AMBIANCE_CITY", this.load("SOTE_SFX_CityAmb_v1.ogg"));
        this.map.put("AMBIANCE_BEYOND", this.load("STS_SFX_BeyondAmb_v1.ogg"));
        this.map.put("SCENE_TORCH_EXTINGUISH", this.load("STS_SFX_BGTorchExtinguish_v1.ogg"));
        this.map.put("APPEAR", this.load("SOTE_SFX_Appear_v2.ogg"));
        this.map.put("ATTACK_DAGGER_1", this.load("STS_SFX_DaggerThrow_1.ogg"));
        this.map.put("ATTACK_DAGGER_2", this.load("STS_SFX_DaggerThrow_2.ogg"));
        this.map.put("ATTACK_DAGGER_3", this.load("STS_SFX_DaggerThrow_3.ogg"));
        this.map.put("ATTACK_DAGGER_4", this.load("STS_SFX_DaggerThrow_2_1.ogg"));
        this.map.put("ATTACK_DAGGER_5", this.load("STS_SFX_DaggerThrow_2_2.ogg"));
        this.map.put("ATTACK_DAGGER_6", this.load("STS_SFX_DaggerThrow_2_3.ogg"));
        this.map.put("ATTACK_DEFECT_BEAM", this.load("STS_SFX_DefectBeam_v1.ogg"));
        this.map.put("ATTACK_FAST", this.load("SOTE_SFX_FastAtk_v2.ogg"));
        this.map.put("ATTACK_FIRE", this.load("SOTE_SFX_FireIgnite_2_v1.ogg"));
        this.map.put("ATTACK_FLAME_BARRIER", this.load("STS_SFX_FlameBarrier_v2.ogg"));
        this.map.put("ATTACK_HEAVY", this.load("SOTE_SFX_HeavyAtk_v2.ogg"));
        this.map.put("ATTACK_IRON_1", this.load("SOTE_SFX_IronClad_Atk_RR1_v2.ogg"));
        this.map.put("ATTACK_IRON_2", this.load("SOTE_SFX_IronClad_Atk_RR2_v2.ogg"));
        this.map.put("ATTACK_IRON_3", this.load("SOTE_SFX_IronClad_Atk_RR3_v2.ogg"));
        this.map.put("ATTACK_MAGIC_BEAM", this.load("SOTE_SFX_SlowMagic_Beam_v1.ogg"));
        this.map.put("ATTACK_MAGIC_BEAM_SHORT", this.load("SOTE_SFX_SlowMagic_BeamShort_v1.ogg"));
        this.map.put("ATTACK_MAGIC_FAST_1", this.load("SOTE_SFX_MagicFast_1_v1.ogg"));
        this.map.put("ATTACK_MAGIC_FAST_2", this.load("SOTE_SFX_MagicFast_2_v1.ogg"));
        this.map.put("ATTACK_MAGIC_FAST_3", this.load("SOTE_SFX_MagicFast_3_v1.ogg"));
        this.map.put("ATTACK_MAGIC_SLOW_1", this.load("SOTE_SFX_SlowMagic_1_v1.ogg"));
        this.map.put("ATTACK_MAGIC_SLOW_2", this.load("SOTE_SFX_SlowMagic_2_v1.ogg"));
        this.map.put("ATTACK_PIERCING_WAIL", this.load("STS_SFX_PiercingWail_v2.ogg"));
        this.map.put("ATTACK_POISON", this.load("SOTE_SFX_PoisonCard_1_v1.ogg"));
        this.map.put("ATTACK_POISON2", this.load("SOTE_SFX_PoisonCard_2_v1.ogg"));
        this.map.put("ATTACK_WHIFF_1", this.load("SOTE_SFX_SlowThrow_1_v1.ogg"));
        this.map.put("ATTACK_WHIFF_2", this.load("SOTE_SFX_SlowThrow_2_v1.ogg"));
        this.map.put("ATTACK_WHIRLWIND", this.load("STS_SFX_Whirlwind_v2.ogg"));
        this.map.put("ATTACK_BOWLING", this.load("bowling.ogg"));
        this.map.put("CARD_DRAW_8", this.load("STS_SFX_CardDeal8_v1.ogg"));
        this.map.put("KEY_OBTAIN", this.load("SOTE_SFX_Key_v2.ogg"));
        this.map.put("AUTOMATON_ORB_SPAWN", this.load("STS_SFX_AutomatonOrbSpawn_v1.ogg"));
        this.map.put("BATTLE_START_BOSS", this.load("STS_SFX_BattleStart_Boss_v1.ogg"));
        this.map.put("BATTLE_START_1", this.load("STS_SFX_BattleStart_1_v1.ogg"));
        this.map.put("BATTLE_START_2", this.load("STS_SFX_BattleStart_2_v1.ogg"));
        this.map.put("BELL", this.load("SOTE_SFX_Bell_v1.ogg"));
        this.map.put("BLOCK_ATTACK", this.load("SOTE_SFX_BlockAtk_v2.ogg"));
        this.map.put("BLOCK_BREAK", this.load("SOTE_SFX_DefenseBreak_v2.ogg"));
        this.map.put("BLOCK_GAIN_1", this.load("SOTE_SFX_GainDefense_RR1_v3.ogg"));
        this.map.put("BLOCK_GAIN_2", this.load("SOTE_SFX_GainDefense_RR3_v3.ogg"));
        this.map.put("BLOCK_GAIN_3", this.load("SOTE_SFX_GainDefense_RR2_v3.ogg"));
        this.map.put("BLOOD_SPLAT", this.load("SOTE_SFX_Blood_2_v2.ogg"));
        this.map.put("BLOOD_SWISH", this.load("SOTE_SFX_Blood_1_v2.ogg"));
        this.map.put("BLUNT_FAST", this.load("SOTE_SFX_FastBlunt_v2.ogg"));
        this.map.put("BLUNT_HEAVY", this.load("SOTE_SFX_HeavyBlunt_v2.ogg"));
        this.map.put("BOSS_VICTORY_STINGER", this.load("STS_BossVictoryStinger_1_v3_SFX.ogg"));
        this.map.put("BUFF_1", this.load("SOTE_SFX_Buff_1_v1.ogg"));
        this.map.put("BUFF_2", this.load("SOTE_SFX_Buff_2_v1.ogg"));
        this.map.put("BUFF_3", this.load("SOTE_SFX_Buff_3_v1.ogg"));
        this.map.put("BYRD_DEATH", this.load("STS_SFX_ByrdDefeat_v2.ogg"));
        this.map.put("CARD_BURN", this.load("STS_SFX_BurnCard_v1.ogg"));
        this.map.put("CARD_EXHAUST", this.load("SOTE_SFX_ExhaustCard.ogg"));
        this.map.put("CARD_OBTAIN", this.load("SOTE_SFX_ObtainCard_v2.ogg"));
        this.map.put("CARD_REJECT", this.load("SOTE_SFX_CardReject_v1.ogg"));
        this.map.put("CARD_SELECT", this.load("SOTE_SFX_CardSelect_v2.ogg"));
        this.map.put("CARD_UPGRADE", this.load("SOTE_SFX_UpgradeCard_v1.ogg"));
        this.map.put("CEILING_BOOM_1", this.load("SOTE_SFX_CeilingDust1_Boom_v1.ogg"));
        this.map.put("CEILING_BOOM_2", this.load("SOTE_SFX_CeilingDust2_Boom_v1.ogg"));
        this.map.put("CEILING_BOOM_3", this.load("SOTE_SFX_CeilingDust3_Boom_v1.ogg"));
        this.map.put("CEILING_DUST_1", this.load("SOTE_SFX_CeilingDust1_v1.ogg"));
        this.map.put("CEILING_DUST_2", this.load("SOTE_SFX_CeilingDust2_v1.ogg"));
        this.map.put("CEILING_DUST_3", this.load("SOTE_SFX_CeilingDust3_v1.ogg"));
        this.map.put("CHEST_OPEN", this.load("SOTE_SFX_ChestOpen_v2.ogg"));
        this.map.put("CHOSEN_DEATH", this.load("STS_SFX_ChosenDefeat_v2.ogg"));
        this.map.put("DARKLING_REGROW_1", this.load("STS_SFX_DarklingRegrow_v2.ogg"));
        this.map.put("DARKLING_REGROW_2", this.load("STS_SFX_DarklingRegrow_2_v2.ogg"));
        this.map.put("DEATH_STINGER", this.load("STS_DeathStinger_v4_SFX.ogg"));
        this.map.put("DEBUFF_1", this.load("SOTE_SFX_Debuff_1_v1.ogg"));
        this.map.put("DEBUFF_2", this.load("SOTE_SFX_Debuff_2_v1.ogg"));
        this.map.put("DEBUFF_3", this.load("SOTE_SFX_Debuff_3_v1.ogg"));
        this.map.put("DECK_CLOSE", this.load("SOTE_SFX_UI_Parchment_2_v1.ogg"));
        this.map.put("DECK_OPEN", this.load("SOTE_SFX_UI_Parchment_3_v1.ogg"));
        this.map.put("DUNGEON_TRANSITION", this.load("SOTE_SFX_DungeonGate.ogg"));
        this.map.put("END_TURN", this.load("SOTE_SFX_EndTurn_v2.ogg"));
        this.map.put("ENEMY_TURN", this.load("SOTE_SFX_EnemyTurn_v3.ogg"));
        this.map.put("EVENT_PURCHASE", this.load("SOTE_SFX_EventPurchase.ogg"));
        this.map.put("EVENT_ANCIENT", this.load("STS_SFX_AncientWriting_v1.ogg"));
        this.map.put("EVENT_FALLING", this.load("STS_SFX_Falling_v1.ogg"));
        this.map.put("EVENT_FORGE", this.load("STS_SFX_OminousForge_v1.ogg"));
        this.map.put("EVENT_FORGOTTEN", this.load("STS_SFX_ForgottenShrine_v1.ogg"));
        this.map.put("EVENT_FOUNTAIN", this.load("STS_SFX_CursedTome_v1.ogg"));
        this.map.put("EVENT_GHOSTS", this.load("STS_SFX_CouncilGhosts-Mausoleum_v1.ogg"));
        this.map.put("EVENT_GOLDEN", this.load("STS_SFX_GoldenIdolBoulder_v1.ogg"));
        this.map.put("EVENT_GOOP", this.load("STS_SFX_WorldOfGoop_v1.ogg"));
        this.map.put("EVENT_LAB", this.load("STS_SFX_Lab_v1.ogg"));
        this.map.put("EVENT_LIVING_WALL", this.load("STS_SFX_LivingWall_v1.ogg"));
        this.map.put("EVENT_NLOTH", this.load("STS_SFX_NLoth_v1.ogg"));
        this.map.put("EVENT_OOZE", this.load("STS_SFX_ScrapOoze_v1.ogg"));
        this.map.put("EVENT_PORTAL", this.load("STS_SFX_SecretPortal_v1.ogg"));
        this.map.put("EVENT_SENSORY", this.load("STS_SFX_SensoryStone_v1.ogg"));
        this.map.put("EVENT_SERPENT", this.load("STS_SFX_Ssserpent_v1.ogg"));
        this.map.put("EVENT_SHINING", this.load("STS_SFX_ShiningLight_v1.ogg"));
        this.map.put("EVENT_SKULL", this.load("STS_SFX_KnowingSkull_v1.ogg"));
        this.map.put("EVENT_SPIRITS", this.load("STS_SFX_BonfireSpirits_v1.ogg"));
        this.map.put("EVENT_TOME", this.load("STS_SFX_CursedTome_v1.ogg"));
        this.map.put("EVENT_WINDING", this.load("STS_SFX_WindingHalls_v1.ogg"));
        this.map.put("EVENT_VAMP_BITE", this.load("STS_SFX_VampireBite_v2.ogg"));
        this.map.put("GHOST_FLAMES", this.load("SOTE_SFX_GhostGuardianFlames_v1.ogg"));
        this.map.put("GHOST_ORB_IGNITE_1", this.load("SOTE_SFX_BossOrbIgnite1_v2.ogg"));
        this.map.put("GHOST_ORB_IGNITE_2", this.load("SOTE_SFX_BossOrbIgnite2_v2.ogg"));
        this.map.put("GOLD_GAIN", this.load("SOTE_SFX_Gold_RR1_v3.ogg"));
        this.map.put("GOLD_GAIN_2", this.load("SOTE_SFX_Gold_RR2_v3.ogg"));
        this.map.put("GOLD_GAIN_3", this.load("SOTE_SFX_Gold_RR3_v3.ogg"));
        this.map.put("GOLD_GAIN_4", this.load("SOTE_SFX_Gold_RR4_v3.ogg"));
        this.map.put("GOLD_GAIN_5", this.load("SOTE_SFX_Gold_RR5_v3.ogg"));
        this.map.put("GOLD_JINGLE", this.load("SOTE_SFX_Gold_v1.ogg"));
        this.map.put("GUARDIAN_ROLL_UP", this.load("SOTE_SFX_BossBallTransform_v1.ogg"));
        this.map.put("HEAL_1", this.load("SOTE_SFX_HealShort_1_v2.ogg"));
        this.map.put("HEAL_2", this.load("SOTE_SFX_HealShort_2_v2.ogg"));
        this.map.put("HEAL_3", this.load("SOTE_SFX_HealShort_3_v2.ogg"));
        this.map.put("HEART_BEAT", this.load("SLS_SFX_HeartBeat_Resonant_v1.ogg"));
        this.map.put("HEART_SIMPLE", this.load("SLS_SFX_HeartBeat_Simple_v1.ogg"));
        this.map.put("HOVER_CHARACTER", this.load("SOTE_SFX_UI_Parchment_3_v1.ogg"));
        this.map.put("INTIMIDATE", this.load("SOTE_SFX_IntimidateCard_v1.ogg"));
        this.map.put("MAP_CLOSE", this.load("SOTE_SFX_UI_Parchment_1_v2.ogg"));
        this.map.put("MAP_HOVER_1", this.load("SOTE_SFX_MapHover_1_v1.ogg"));
        this.map.put("MAP_HOVER_2", this.load("SOTE_SFX_MapHover_2_v1.ogg"));
        this.map.put("MAP_HOVER_3", this.load("SOTE_SFX_MapHover_3_v1.ogg"));
        this.map.put("MAP_HOVER_4", this.load("SOTE_SFX_MapHover_4_v1.ogg"));
        this.map.put("MAP_OPEN", this.load("SOTE_SFX_Map_1_v3.ogg"));
        this.map.put("MAP_OPEN_2", this.load("SOTE_SFX_Map_2_v3.ogg"));
        this.map.put("MAP_SELECT_1", this.load("SOTE_SFX_MapSelect_1_v1.ogg"));
        this.map.put("MAP_SELECT_2", this.load("SOTE_SFX_MapSelect_2_v1.ogg"));
        this.map.put("MAP_SELECT_3", this.load("SOTE_SFX_MapSelect_3_v1.ogg"));
        this.map.put("MAP_SELECT_4", this.load("SOTE_SFX_MapSelect_4_v1.ogg"));
        this.map.put("MAW_DEATH", this.load("STS_SFX_MawDefeat_v2.ogg"));
        this.map.put("NECRONOMICON", this.load("SOTE_SFX_NecroLaugh_v2.ogg"));
        this.map.put("NULLIFY_SFX", this.load("STS_SFX_Nullify_v1.ogg"));
        this.map.put("POTION_1", this.load("SOTE_SFX_Potion_1_v2.ogg"));
        this.map.put("POTION_2", this.load("SOTE_SFX_Potion_2_v2.ogg"));
        this.map.put("POTION_3", this.load("SOTE_SFX_Potion_3_v2.ogg"));
        this.map.put("POTION_DROP_1", this.load("SOTE_SFX_DropPotion_1_v1.ogg"));
        this.map.put("POTION_DROP_2", this.load("SOTE_SFX_DropPotion_2_v1.ogg"));
        this.map.put("JAW_WORM_DEATH", this.load("STS_SFX_JawWormDefeat_v2.ogg"));
        this.map.put("MONSTER_AUTOMATON_SUMMON", this.load("STS_SFX_BronzeAutomatonSummon_v2.ogg"));
        this.map.put("MONSTER_AWAKENED_ATTACK", this.load("STS_SFX_AwakenedOne3Atk_v1.ogg"));
        this.map.put("MONSTER_AWAKENED_POUNCE", this.load("STS_SFX_AwakenedOnePounce_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_0", this.load("STS_SFX_ByrdAtk1_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_1", this.load("STS_SFX_ByrdAtk2_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_2", this.load("STS_SFX_ByrdAtk3_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_3", this.load("STS_SFX_ByrdAtk4_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_4", this.load("STS_SFX_ByrdAtk5_v2.ogg"));
        this.map.put("MONSTER_BYRD_ATTACK_5", this.load("STS_SFX_ByrdAtk6_v2.ogg"));
        this.map.put("MONSTER_CHAMP_CHARGE", this.load("STS_SFX_ChampChargeUp_v2.ogg"));
        this.map.put("MONSTER_CHAMP_SLAP", this.load("STS_SFX_ChampSlap_v2.ogg"));
        this.map.put("MONSTER_COLLECTOR_DEBUFF", this.load("STS_SFX_CollectorDebuff_v2.ogg"));
        this.map.put("MONSTER_COLLECTOR_SUMMON", this.load("STS_SFX_CollectorSummon_v2.ogg"));
        this.map.put("MONSTER_DONU_DEFENSE", this.load("STS_SFX_DonuDecaDefense_v2.ogg"));
        this.map.put("MONSTER_GUARDIAN_DESTROY", this.load("STS_SFX_Guardian3Destroy_v2.ogg"));
        this.map.put("MONSTER_JAW_WORM_BELLOW", this.load("STS_SFX_JawWormBellow_v1.ogg"));
        this.map.put("MONSTER_SLIME_ATTACK", this.load("STS_SFX_SlimedAtk_v2.ogg"));
        this.map.put("MONSTER_BOOK_STAB_0", this.load("STS_SFX_BookofStabbing1_v1.ogg"));
        this.map.put("MONSTER_BOOK_STAB_1", this.load("STS_SFX_BookofStabbing2_v1.ogg"));
        this.map.put("MONSTER_BOOK_STAB_2", this.load("STS_SFX_BookofStabbing3_v1.ogg"));
        this.map.put("MONSTER_BOOK_STAB_3", this.load("STS_SFX_BookofStabbing4_v1.ogg"));
        this.map.put("MONSTER_SNECKO_GLARE", this.load("STS_SFX_SneckoGlareWave_v1.ogg"));
        this.map.put("POWER_CONFUSION", this.load("STS_SFX_Confused_v2.ogg"));
        this.map.put("POWER_CONSTRICTED", this.load("STS_SFX_Constrict_v2.ogg"));
        this.map.put("POWER_DEXTERITY", this.load("STS_SFX_Dexterity_v2.ogg"));
        this.map.put("POWER_ENTANGLED", this.load("STS_SFX_Entangle_v2.ogg"));
        this.map.put("POWER_FLIGHT", this.load("STS_SFX_Flight_v2.ogg"));
        this.map.put("POWER_FOCUS", this.load("STS_SFX_Focus_v2.ogg"));
        this.map.put("POWER_INTANGIBLE", this.load("STS_SFX_Intangible_v1.ogg"));
        this.map.put("POWER_METALLICIZE", this.load("STS_SFX_Metallicize_v2.ogg"));
        this.map.put("POWER_PLATED", this.load("STS_SFX_PlateArmor_v2.ogg"));
        this.map.put("POWER_POISON", this.load("STS_SFX_PoisonApply_v1.ogg"));
        this.map.put("POWER_SHACKLE", this.load("STS_SFX_Shackled_v1.ogg"));
        this.map.put("POWER_STRENGTH", this.load("STS_SFX_Strength_v1.ogg"));
        this.map.put("POWER_TIME_WARP", this.load("STS_SFX_TimeWarp_v2.ogg"));
        this.map.put("RAGE", this.load("SOTE_SFX_RageCard_v1.ogg"));
        this.map.put("RELIC_DROP_CLINK", this.load("SOTE_SFX_DropRelic_Clink.ogg"));
        this.map.put("RELIC_DROP_FLAT", this.load("SOTE_SFX_DropRelic_Flat.ogg"));
        this.map.put("RELIC_DROP_HEAVY", this.load("SOTE_SFX_DropRelic_Heavy.ogg"));
        this.map.put("RELIC_DROP_MAGICAL", this.load("SOTE_SFX_DropRelic_Magical.ogg"));
        this.map.put("RELIC_DROP_ROCKY", this.load("SOTE_SFX_DropRelic_Rocky.ogg"));
        this.map.put("REST_FIRE_DRY", this.load("SOTE_SFX_RestFireDry_v2.ogg"));
        this.map.put("REST_FIRE_WET", this.load("SOTE_SFX_RestFireWet_v2.ogg"));
        this.map.put("SHOP_CLOSE", this.load("SOTE_SFX_ShopRugClose_v1.ogg"));
        this.map.put("SHOP_OPEN", this.load("SOTE_SFX_ShopRugOpen_v1.ogg"));
        this.map.put("SHOP_PURCHASE", this.load("SOTE_SFX_CashRegister.ogg"));
        this.map.put("SHOVEL", this.load("sts_sfx_shovel_v1.ogg"));
        this.map.put("SINGING_BOWL", this.load("SOTE_SFX_Relic_PrayerBowl_Soft.ogg"));
        this.map.put("SLEEP_1-1", this.load("STS_SleepJingle_1a_NewMix_v1.ogg"));
        this.map.put("SLEEP_1-2", this.load("STS_SleepJingle_1b_NewMix_v1.ogg"));
        this.map.put("SLEEP_1-3", this.load("STS_SleepJingle_1c_NewMix_v1.ogg"));
        this.map.put("SLEEP_2-1", this.load("STS_SleepJingle_2a_NewMix_v1.ogg"));
        this.map.put("SLEEP_2-2", this.load("STS_SleepJingle_2b_NewMix_v1.ogg"));
        this.map.put("SLEEP_2-3", this.load("STS_SleepJingle_2c_NewMix_v1.ogg"));
        this.map.put("SLEEP_3-1", this.load("STS_SleepJingle_3a_NewMix_v1.ogg"));
        this.map.put("SLEEP_3-2", this.load("STS_SleepJingle_3b_NewMix_v1.ogg"));
        this.map.put("SLEEP_3-3", this.load("STS_SleepJingle_3c_NewMix_v1.ogg"));
        this.map.put("SLEEP_BLANKET", this.load("SOTE_SFX_SleepBlanket_v1.ogg"));
        this.map.put("SLIME_ATTACK", this.load("SOTE_SFX_SlimeAtk_1_v1.ogg"));
        this.map.put("SLIME_ATTACK_2", this.load("SOTE_SFX_SlimeAtk_2_v1.ogg"));
        this.map.put("SLIME_BLINK_1", this.load("SOTE_SFX_SlimeBlink_1_v2.ogg"));
        this.map.put("SLIME_BLINK_2", this.load("SOTE_SFX_SlimeBlink_2_v1.ogg"));
        this.map.put("SLIME_BLINK_3", this.load("SOTE_SFX_SlimeBlink_3_v1.ogg"));
        this.map.put("SLIME_BLINK_4", this.load("SOTE_SFX_SlimeBlink_4_v1.ogg"));
        this.map.put("SLIME_SPLIT", this.load("SOTE_SFX_SlimeSplit_v1.ogg"));
        this.map.put("SNECKO_DEATH", this.load("STS_SFX_SerpentSneckoDefeat_v2.ogg"));
        this.map.put("SPHERE_DETECT_VO_1", this.load("STS_SFX_GuardianOutsiderDetected_1_v1.ogg"));
        this.map.put("SPHERE_DETECT_VO_2", this.load("STS_SFX_GuardianOutsiderDetected_2_v1.ogg"));
        this.map.put("SPLASH", this.load("SOTE_Logo_Echoing_ShortTail.ogg"));
        this.map.put("SPORE_CLOUD_RELEASE", this.load("STS_SFX_SporeCloud.ogg"));
        this.map.put("STAB_BOOK_DEATH", this.load("STS_SFX_BookOfStabbingDefeat_v2.ogg"));
        this.map.put("THUNDERCLAP", this.load("SOTE_SFX_ThunderclapCard_v1.ogg"));
        this.map.put("TINGSHA", this.load("SOTE_SFX_Relic_Tingsha.ogg"));
        this.map.put("DAMARU", this.load("damaru.ogg"));
        this.map.put("TURN_EFFECT", this.load("SOTE_SFX_PlayerTurn_v4_1.ogg"));
        this.map.put("UI_CLICK_1", this.load("SOTE_SFX_UIClick_1_v2.wav"));
        this.map.put("UI_CLICK_2", this.load("SOTE_SFX_UIClick_2_v2.wav"));
        this.map.put("UI_HOVER", this.load("SOTE_SFX_UIHover_v2.wav"));
        this.map.put("UNLOCK_SCREEN", this.load("STS_UnlockScreen_v1.ogg"));
        this.map.put("UNLOCK_WHIR", this.load("STS_XPBar_Classic_v1.ogg"));
        this.map.put("UNLOCK_PING", this.load("STS_NewUnlock_v1.ogg"));
        this.map.put("VICTORY", this.load("SOTE_SFX_Victory_v1.ogg"));
        this.map.put("WHEEL", this.load("SOTE_SFX_Wheel_v2.ogg"));
        this.map.put("WIND", this.load("SOTE_SFX_WindAmb_v1.ogg"));
        this.map.put("VO_AWAKENEDONE_1", this.load("vo/STS_VO_AwakenedOne_1_v2.ogg"));
        this.map.put("VO_AWAKENEDONE_2", this.load("vo/STS_VO_AwakenedOne_2_v2.ogg"));
        this.map.put("VO_AWAKENEDONE_3", this.load("vo/STS_VO_AwakenedOne_3_v2.ogg"));
        this.map.put("VO_CULTIST_1A", this.load("vo/STS_VO_CrowCultist_1a.ogg"));
        this.map.put("VO_CULTIST_1B", this.load("vo/STS_VO_CrowCultist_1b.ogg"));
        this.map.put("VO_CULTIST_1C", this.load("vo/STS_VO_CrowCultist_1c.ogg"));
        this.map.put("VO_CULTIST_2A", this.load("vo/STS_VO_CrowCultist_2a.ogg"));
        this.map.put("VO_CULTIST_2B", this.load("vo/STS_VO_CrowCultist_2b.ogg"));
        this.map.put("VO_CULTIST_2C", this.load("vo/STS_VO_CrowCultist_2c.ogg"));
        this.map.put("VO_FLAMEBRUISER_1", this.load("vo/STS_VO_FlameBruiser_1_v3.ogg"));
        this.map.put("VO_FLAMEBRUISER_2", this.load("vo/STS_VO_FlameBruiser_2_v3.ogg"));
        this.map.put("VO_GIANTHEAD_1A", this.load("vo/STS_VO_GiantHead_1a.ogg"));
        this.map.put("VO_GIANTHEAD_1B", this.load("vo/STS_VO_GiantHead_1b.ogg"));
        this.map.put("VO_GIANTHEAD_1C", this.load("vo/STS_VO_GiantHead_1c.ogg"));
        this.map.put("VO_GIANTHEAD_2A", this.load("vo/STS_VO_GiantHead_2a.ogg"));
        this.map.put("VO_GIANTHEAD_2B", this.load("vo/STS_VO_GiantHead_2b.ogg"));
        this.map.put("VO_GIANTHEAD_2C", this.load("vo/STS_VO_GiantHead_2c.ogg"));
        this.map.put("VO_GREMLINANGRY_1A", this.load("vo/STS_VO_GremlinAngry_1a.ogg"));
        this.map.put("VO_GREMLINANGRY_1B", this.load("vo/STS_VO_GremlinAngry_1b.ogg"));
        this.map.put("VO_GREMLINANGRY_1C", this.load("vo/STS_VO_GremlinAngry_1c.ogg"));
        this.map.put("VO_GREMLINANGRY_2A", this.load("vo/STS_VO_GremlinAngry_2a.ogg"));
        this.map.put("VO_GREMLINANGRY_2B", this.load("vo/STS_VO_GremlinAngry_2b.ogg"));
        this.map.put("VO_GREMLINCALM_1A", this.load("vo/STS_VO_GremlinCalm_1a.ogg"));
        this.map.put("VO_GREMLINCALM_1B", this.load("vo/STS_VO_GremlinCalm_1b.ogg"));
        this.map.put("VO_GREMLINCALM_2A", this.load("vo/STS_VO_GremlinCalm_2a.ogg"));
        this.map.put("VO_GREMLINCALM_2B", this.load("vo/STS_VO_GremlinCalm_2b.ogg"));
        this.map.put("VO_GREMLINDOPEY_1A", this.load("vo/STS_VO_GremlinDopey_1a.ogg"));
        this.map.put("VO_GREMLINDOPEY_1B", this.load("vo/STS_VO_GremlinDopey_1b.ogg"));
        this.map.put("VO_GREMLINDOPEY_2A", this.load("vo/STS_VO_GremlinDopey_2a.ogg"));
        this.map.put("VO_GREMLINDOPEY_2B", this.load("vo/STS_VO_GremlinDopey_2b.ogg"));
        this.map.put("VO_GREMLINDOPEY_2C", this.load("vo/STS_VO_GremlinDopey_2c.ogg"));
        this.map.put("VO_GREMLINFAT_1A", this.load("vo/STS_VO_GremlinFat_1a.ogg"));
        this.map.put("VO_GREMLINFAT_1B", this.load("vo/STS_VO_GremlinFat_1b.ogg"));
        this.map.put("VO_GREMLINFAT_1C", this.load("vo/STS_VO_GremlinFat_1c.ogg"));
        this.map.put("VO_GREMLINFAT_2A", this.load("vo/STS_VO_GremlinFat_2a.ogg"));
        this.map.put("VO_GREMLINFAT_2B", this.load("vo/STS_VO_GremlinFat_2b.ogg"));
        this.map.put("VO_GREMLINFAT_2C", this.load("vo/STS_VO_GremlinFat_2c.ogg"));
        this.map.put("VO_GREMLINNOB_1A", this.load("vo/STS_VO_GremlinNob_1a_v3.ogg"));
        this.map.put("VO_GREMLINNOB_1B", this.load("vo/STS_VO_GremlinNob_1b_v3.ogg"));
        this.map.put("VO_GREMLINNOB_1C", this.load("vo/STS_VO_GremlinNob_1d2b_v3.ogg"));
        this.map.put("VO_GREMLINNOB_2A", this.load("vo/STS_VO_GremlinNob_2a_v3.ogg"));
        this.map.put("VO_GREMLINSPAZZY_1A", this.load("vo/STS_VO_GremlinSpazzy_1a.ogg"));
        this.map.put("VO_GREMLINSPAZZY_1B", this.load("vo/STS_VO_GremlinSpazzy_1b.ogg"));
        this.map.put("VO_GREMLINSPAZZY_2A", this.load("vo/STS_VO_GremlinSpazzy_2a.ogg"));
        this.map.put("VO_GREMLINSPAZZY_2B", this.load("vo/STS_VO_GremlinSpazzy_2b.ogg"));
        this.map.put("VO_GREMLINSPAZZY_2C", this.load("vo/STS_VO_GremlinSpazzy_2c.ogg"));
        this.map.put("VO_HEALER_1A", this.load("vo/STS_VO_Healer_1a.ogg"));
        this.map.put("VO_HEALER_1B", this.load("vo/STS_VO_Healer_1b.ogg"));
        this.map.put("VO_HEALER_2A", this.load("vo/STS_VO_Healer_2a.ogg"));
        this.map.put("VO_HEALER_2B", this.load("vo/STS_VO_Healer_2b.ogg"));
        this.map.put("VO_HEALER_2C", this.load("vo/STS_VO_Healer_2c.ogg"));
        this.map.put("VO_IRONCLAD_1A", this.load("vo/STS_VO_Ironclad_1a.ogg"));
        this.map.put("VO_IRONCLAD_1B", this.load("vo/STS_VO_Ironclad_1b.ogg"));
        this.map.put("VO_IRONCLAD_1C", this.load("vo/STS_VO_Ironclad_1c.ogg"));
        this.map.put("VO_IRONCLAD_2A", this.load("vo/STS_VO_Ironclad_2a.ogg"));
        this.map.put("VO_IRONCLAD_2B", this.load("vo/STS_VO_Ironclad_2b.ogg"));
        this.map.put("VO_IRONCLAD_2C", this.load("vo/STS_VO_Ironclad_2c.ogg"));
        this.map.put("VO_LOOTER_1A", this.load("vo/STS_VO_Looter_1a.ogg"));
        this.map.put("VO_LOOTER_1B", this.load("vo/STS_VO_Looter_1b.ogg"));
        this.map.put("VO_LOOTER_1C", this.load("vo/STS_VO_Looter_1c.ogg"));
        this.map.put("VO_LOOTER_2A", this.load("vo/STS_VO_Looter_2a.ogg"));
        this.map.put("VO_LOOTER_2B", this.load("vo/STS_VO_Looter_2b.ogg"));
        this.map.put("VO_LOOTER_2C", this.load("vo/STS_VO_Looter_2c.ogg"));
        this.map.put("VO_MERCENARY_1A", this.load("vo/STS_VO_Mercenary_1a.ogg"));
        this.map.put("VO_MERCENARY_1B", this.load("vo/STS_VO_Mercenary_1b.ogg"));
        this.map.put("VO_MERCENARY_2A", this.load("vo/STS_VO_Mercenary_2a.ogg"));
        this.map.put("VO_MERCENARY_3A", this.load("vo/STS_VO_Mercenary_3a.ogg"));
        this.map.put("VO_MERCENARY_3B", this.load("vo/STS_VO_Mercenary_3b.ogg"));
        this.map.put("VO_MERCHANT_2A", this.load("vo/STS_VO_Merchant_2a.ogg"));
        this.map.put("VO_MERCHANT_2B", this.load("vo/STS_VO_Merchant_2b.ogg"));
        this.map.put("VO_MERCHANT_2C", this.load("vo/STS_VO_Merchant_2c.ogg"));
        this.map.put("VO_MERCHANT_3A", this.load("vo/STS_VO_Merchant_3a.ogg"));
        this.map.put("VO_MERCHANT_3B", this.load("vo/STS_VO_Merchant_3b.ogg"));
        this.map.put("VO_MERCHANT_3C", this.load("vo/STS_VO_Merchant_3c.ogg"));
        this.map.put("VO_MERCHANT_KA", this.load("vo/STS_VO_Merchant_Kekeke_a.ogg"));
        this.map.put("VO_MERCHANT_KB", this.load("vo/STS_VO_Merchant_Kekeke_b.ogg"));
        this.map.put("VO_MERCHANT_KC", this.load("vo/STS_VO_Merchant_Kekeke_c.ogg"));
        this.map.put("VO_MERCHANT_MA", this.load("vo/STS_VO_Merchant_Mlyah_a.ogg"));
        this.map.put("VO_MERCHANT_MB", this.load("vo/STS_VO_Merchant_Mlyah_b.ogg"));
        this.map.put("VO_MERCHANT_MC", this.load("vo/STS_VO_Merchant_Mlyah_c.ogg"));
        this.map.put("VO_MUGGER_1A", this.load("vo/STS_VO_Mugger_1a.ogg"));
        this.map.put("VO_MUGGER_1B", this.load("vo/STS_VO_Mugger_1b.ogg"));
        this.map.put("VO_MUGGER_2A", this.load("vo/STS_VO_Mugger_2a.ogg"));
        this.map.put("VO_MUGGER_2B", this.load("vo/STS_VO_Mugger_2b.ogg"));
        this.map.put("VO_NEMESIS_1A", this.load("vo/STS_VO_Nemesis_1a.ogg"));
        this.map.put("VO_NEMESIS_1B", this.load("vo/STS_VO_Nemesis_1b.ogg"));
        this.map.put("VO_NEMESIS_1C", this.load("vo/STS_VO_Nemesis_1c.ogg"));
        this.map.put("VO_NEMESIS_2A", this.load("vo/STS_VO_Nemesis_2a.ogg"));
        this.map.put("VO_NEMESIS_2B", this.load("vo/STS_VO_Nemesis_2b.ogg"));
        this.map.put("VO_NEOW_1A", this.load("vo/STS_VO_Neow_1a.ogg"));
        this.map.put("VO_NEOW_1B", this.load("vo/STS_VO_Neow_1b.ogg"));
        this.map.put("VO_NEOW_2A", this.load("vo/STS_VO_Neow_2a.ogg"));
        this.map.put("VO_NEOW_2B", this.load("vo/STS_VO_Neow_2b.ogg"));
        this.map.put("VO_NEOW_3A", this.load("vo/STS_VO_Neow_3a.ogg"));
        this.map.put("VO_NEOW_3B", this.load("vo/STS_VO_Neow_3b.ogg"));
        this.map.put("VO_SILENT_1A", this.load("vo/STS_VO_Silent_1a.ogg"));
        this.map.put("VO_SILENT_1B", this.load("vo/STS_VO_Silent_1b.ogg"));
        this.map.put("VO_SILENT_2A", this.load("vo/STS_VO_Silent_2a.ogg"));
        this.map.put("VO_SILENT_2B", this.load("vo/STS_VO_Silent_2b.ogg"));
        this.map.put("VO_SLAVERBLUE_1A", this.load("vo/STS_VO_SlaverBlue_1a.ogg"));
        this.map.put("VO_SLAVERBLUE_1B", this.load("vo/STS_VO_SlaverBlue_1b.ogg"));
        this.map.put("VO_SLAVERBLUE_2A", this.load("vo/STS_VO_SlaverBlue_2a.ogg"));
        this.map.put("VO_SLAVERBLUE_2B", this.load("vo/STS_VO_SlaverBlue_2b.ogg"));
        this.map.put("VO_SLAVERLEADER_1A", this.load("vo/STS_VO_SlaverLeader_1a.ogg"));
        this.map.put("VO_SLAVERLEADER_1B", this.load("vo/STS_VO_SlaverLeader_1b.ogg"));
        this.map.put("VO_SLAVERLEADER_2A", this.load("vo/STS_VO_SlaverLeader_2a.ogg"));
        this.map.put("VO_SLAVERLEADER_2B", this.load("vo/STS_VO_SlaverLeader_2b.ogg"));
        this.map.put("VO_SLAVERRED_1A", this.load("vo/STS_VO_SlaverRed_1a.ogg"));
        this.map.put("VO_SLAVERRED_1B", this.load("vo/STS_VO_SlaverRed_1b.ogg"));
        this.map.put("VO_SLAVERRED_2A", this.load("vo/STS_VO_SlaverRed_2a.ogg"));
        this.map.put("VO_SLAVERRED_2B", this.load("vo/STS_VO_SlaverRed_2b.ogg"));
        this.map.put("VO_SLIMEBOSS_1A", this.load("vo/STS_VO_SlimeBoss_1a.ogg"));
        this.map.put("VO_SLIMEBOSS_1B", this.load("vo/STS_VO_SlimeBoss_1b.ogg"));
        this.map.put("VO_SLIMEBOSS_1C", this.load("vo/STS_VO_SlimeBoss_1c.ogg"));
        this.map.put("VO_SLIMEBOSS_2A", this.load("vo/STS_VO_SlimeBoss_2a.ogg"));
        this.map.put("VO_TANK_1A", this.load("vo/STS_VO_Centurion_1_v2.ogg"));
        this.map.put("VO_TANK_1B", this.load("vo/STS_VO_Centurion_2_v2.ogg"));
        this.map.put("VO_TANK_1C", this.load("vo/STS_VO_Centurion_3_v2.ogg"));
        this.map.put("VO_CHAMP_1A", this.load("vo/STS_VO_TheChamp_1.ogg"));
        this.map.put("VO_CHAMP_2A", this.load("vo/STS_VO_TheChamp_2a.ogg"));
        this.map.put("VO_CHAMP_3A", this.load("vo/STS_VO_TheChamp_3a.ogg"));
        this.map.put("VO_CHAMP_3B", this.load("vo/STS_VO_TheChamp_3b.ogg"));
        this.map.put("ORB_DARK_CHANNEL", this.load("orb/STS_SFX_DarkOrb_Channel_v1.ogg"));
        this.map.put("ORB_DARK_EVOKE", this.load("orb/STS_SFX_DarkOrb_Evoke_v1.ogg"));
        this.map.put("ORB_FROST_CHANNEL", this.load("orb/STS_SFX_FrostOrb_Channel_v1.ogg"));
        this.map.put("ORB_FROST_DEFEND_1", this.load("orb/STS_SFX_FrostOrb_GainDefense_1_v1.ogg"));
        this.map.put("ORB_FROST_DEFEND_2", this.load("orb/STS_SFX_FrostOrb_GainDefense_2_v1.ogg"));
        this.map.put("ORB_FROST_DEFEND_3", this.load("orb/STS_SFX_FrostOrb_GainDefense_3_v1.ogg"));
        this.map.put("ORB_FROST_EVOKE", this.load("orb/STS_SFX_FrostOrb_Evoke_v1.ogg"));
        this.map.put("ORB_LIGHTNING_CHANNEL", this.load("orb/STS_SFX_LightningOrb_Channel_v1.ogg"));
        this.map.put("ORB_LIGHTNING_EVOKE", this.load("orb/STS_SFX_LightningOrb_Evoke_v1.ogg"));
        this.map.put("ORB_LIGHTNING_PASSIVE", this.load("orb/STS_SFX_LightningOrb_Passive_v1.ogg"));
        this.map.put("ORB_PLASMA_CHANNEL", this.load("orb/STS_SFX_PlasmaOrb_Channel_v1.ogg"));
        this.map.put("ORB_PLASMA_EVOKE", this.load("orb/STS_SFX_PlasmaOrb_Evoke_v1.ogg"));
        this.map.put("ORB_SLOT_GAIN", this.load("orb/STS_SFX_GainSlot_v1.ogg"));
        this.map.put("WATCHER_HEART_PUNCH", this.load("SOTE_SFX_BossGhostFireAtk_3_v1.ogg"));
        this.map.put("STANCE_ENTER_CALM", this.load("watcher/STS_SFX_Watcher-Calm_v2.ogg"));
        this.map.put("STANCE_ENTER_WRATH", this.load("watcher/STS_SFX_Watcher-Wrath_v2.ogg"));
        this.map.put("STANCE_ENTER_DIVINITY", this.load("watcher/STS_SFX_Watcher-Divinity_v3.ogg"));
        this.map.put("STANCE_LOOP_CALM", this.load("watcher/STS_SFX_Watcher-CalmLoop_v2.ogg"));
        this.map.put("STANCE_LOOP_WRATH", this.load("watcher/STS_SFX_Watcher-WrathLoop_v2.ogg"));
        this.map.put("STANCE_LOOP_DIVINITY", this.load("watcher/STS_SFX_Watcher-DivinityLoop_v2.ogg"));
        this.map.put("SELECT_WATCHER", this.load("watcher/STS_SFX_Watcher-Select_v2.ogg"));
        this.map.put("POWER_MANTRA", this.load("watcher/STS_SFX_Watcher-Mantra_v3.ogg"));
        this.map.put("CARD_POWER_WOOSH", this.load("STS_SFX_PowerWoosh_v1.ogg"));
        this.map.put("CARD_POWER_IMPACT", this.load("STS_SFX_Power_v1.ogg"));
        logger.info("Sound Effect Volume: " + Settings.SOUND_VOLUME);
        logger.info("Loaded " + this.map.size() + " Sound Effects");
        logger.info("SFX load time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private Sfx load(String filename) {
        return this.load(filename, false);
    }

    private Sfx load(String filename, boolean preload) {
        return new Sfx("audio/sound/" + filename, preload);
    }

    public void update() {
        Iterator<SoundInfo> i = this.fadeOutList.iterator();

        while(i.hasNext()) {
            SoundInfo e = (SoundInfo)i.next();
            e.update();
            Sfx sfx = (Sfx)this.map.get(e.name);
            if (sfx != null) {
                if (e.isDone) {
                    sfx.stop(e.id);
                    i.remove();
                } else {
                    sfx.setVolume(e.id, Settings.SOUND_VOLUME * Settings.MASTER_VOLUME * e.volumeMultiplier);
                }
            }
        }

    }

    public void preload(String key) {
        if (this.map.containsKey(key)) {
            logger.info("Preloading: " + key);
            long id = ((Sfx)this.map.get(key)).play(0.0F);
            ((Sfx)this.map.get(key)).stop(id);
        } else {
            logger.info("Missing: " + key);
        }

    }

    public long play(String key, boolean useBgmVolume) {
        if (CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded) {
            return 0L;
        } else if (this.map.containsKey(key)) {
            return useBgmVolume ? ((Sfx)this.map.get(key)).play(Settings.MUSIC_VOLUME * Settings.MASTER_VOLUME) : ((Sfx)this.map.get(key)).play(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long play(String key) {
        return CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded ? 0L : this.play(key, false);
    }

    public long play(String key, float pitchVariation) {
        if (CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded) {
            return 0L;
        } else if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).play(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME, 1.0F + MathUtils.random(-pitchVariation, pitchVariation), 0.0F);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long playA(String key, float pitchAdjust) {
        if (CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded) {
            return 0L;
        } else if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).play(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME, 1.0F + pitchAdjust, 0.0F);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long playV(String key, float volumeMod) {
        if (CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded) {
            return 0L;
        } else if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).play(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME * volumeMod, 1.0F, 0.0F);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long playAV(String key, float pitchAdjust, float volumeMod) {
        if (CardCrawlGame.MUTE_IF_BG && Settings.isBackgrounded) {
            return 0L;
        } else if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).play(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME * volumeMod, 1.0F + pitchAdjust, 0.0F);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long playAndLoop(String key) {
        if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).loop(Settings.SOUND_VOLUME * Settings.MASTER_VOLUME);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public long playAndLoop(String key, float volume) {
        if (this.map.containsKey(key)) {
            return ((Sfx)this.map.get(key)).loop(volume);
        } else {
            logger.info("Missing: " + key);
            return 0L;
        }
    }

    public void adjustVolume(String key, long id, float volume) {
        ((Sfx)this.map.get(key)).setVolume(id, volume);
    }

    public void adjustVolume(String key, long id) {
        ((Sfx)this.map.get(key)).setVolume(id, Settings.SOUND_VOLUME * Settings.MASTER_VOLUME);
    }

    public void fadeOut(String key, long id) {
        this.fadeOutList.add(new SoundInfo(key, id));
    }

    public void stop(String key, long id) {
        ((Sfx)this.map.get(key)).stop(id);
    }

    public void stop(String key) {
        if (this.map.get(key) != null) {
            ((Sfx)this.map.get(key)).stop();
        }

    }
}
