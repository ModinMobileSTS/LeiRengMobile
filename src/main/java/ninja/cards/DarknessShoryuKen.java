package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class DarknessShoryuKen extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DarknessShoryuKen");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DarknessShoryuKen.png";
    public static final String ID = "DarknessShoryuKen";

    public DarknessShoryuKen(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 12;
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);

    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new NinjutsuAction( p , new DamageAction(m, new DamageInfo(p , this.damage , DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT),1,"DarknessShoryuKen"));
        this.addToBot(new ExhaustAction(1, false));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(3);
        }
    }

    public AbstractCard makeCopy(){
        return new DarknessShoryuKen();
    }
}
