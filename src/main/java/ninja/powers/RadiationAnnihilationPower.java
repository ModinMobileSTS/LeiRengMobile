package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class RadiationAnnihilationPower extends AbstractPower {
    public static final String POWER_ID = "RadiationAnnihilationPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("RadiationAnnihilationPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public RadiationAnnihilationPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.DEBUFF; // 定义为负面效果
        this.priority = 100;

        String path128 = "img/powers_Ninja/NuclearDragonPower84.png";
        String path48 = "img/powers_Ninja/NuclearDragonPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0];


    }

    @Override
    public void atEndOfRound() {
        // 回合结束时减少层数
        flash();
        if (this.amount > 0) {
            this.amount--;
            updateDescription();

            // 如果层数归零则移除能力
            if (this.amount <= 0) {
                AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(owner, owner, this));
            }
        }
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        int DeathCount = 5;
        int LoseHP=this.owner.maxHealth-20;
        int LostHp = this.owner.maxHealth - this.owner.currentHealth;
        // 检查是否达到死亡阈值

        if (this.amount >= DeathCount) {// 立即杀死目标
            if(LostHp >=20){
                this.addToBot(new InstantKillAction(this.owner));
            }
            else {
                this.owner.increaseMaxHp(-LoseHP, false);
            }
            AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(owner, owner, this));
        }
    }
}
