package ninja.cards;

import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.IgnisHealingPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;

public class IgnisHealing extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("IgnisHealing");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/IgnisHealing.png";
    public static final String ID = "IgnisHealing";

    public IgnisHealing(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play(ID);
                this.addToTop(new VFXAction(AbstractDungeon.player, new InflameEffect(AbstractDungeon.player), 0.5F));
        int healAmt =( AbstractDungeon.player.maxHealth / 10 )*this.magicNumber;
        if (healAmt < 1) {
            healAmt = 1;
        }
        this.addToBot(new HealAction(p ,p ,healAmt));
        this.addToBot(new ApplyPowerAction(p,p,new IgnisHealingPower( p ),1));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new IgnisHealing();
    }
}
