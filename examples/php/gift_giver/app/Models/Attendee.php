<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Attendee extends Model
{
    protected $fillable = [
        'name', 'vendor_member_id', 'awarded',
    ];

    protected $attributes = [
        'awarded' => false,
    ];

    protected $casts = [
        'awarded' => 'boolean',
    ];

    public function scopeNotAwarded($query)
    {
        return $query->where('awarded', false);
    }

    public function scopeAwarded($query)
    {
        return $query->where('awarded', true);
    }

    public function scopeMemberId($query, $memberId)
    {
        return $query->where('vendor_member_id', $memberId);
    }
}
